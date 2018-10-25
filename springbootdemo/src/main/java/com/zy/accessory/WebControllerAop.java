package com.zy.accessory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zy.vo.JsonResult;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class WebControllerAop {

    private Logger log = Logger.getLogger(getClass());

    /**
     * 后置返回通知 这里需要注意的是: 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
     * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数 returning
     * 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，
     * 对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
     *
     * @param joinPoint
     * @param keys
     */
    @SuppressWarnings("rawtypes")
    @AfterReturning(value = "execution(* com.zy.web..*.*(..))", returning = "keys")
    public void doAfterReturningAdvice1(JoinPoint joinPoint, Object keys) {
        try {
            // 判断如果返回不是rest接口的数据，直接返回
            if (!keys.getClass().equals(JsonResult.class)) {
                return;
            }
            // 获取目标方法的参数信息
            // Object[] obj = joinPoint.getArgs();
            // AOP代理类的信息
            // joinPoint.getThis();
            // 代理的目标对象
            // joinPoint.getTarget();
            // 用的最多 通知的签名
            Signature signature = joinPoint.getSignature();
            // 代理的是哪一个方法
            // System.out.println(signature.getName());
            // AOP代理类的名字
            // System.out.println(signature.getDeclaringTypeName());
            // AOP代理类的类（class）信息
            // signature.getDeclaringType();
            // 获取RequestAttributes
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            // 从获取RequestAttributes中获取HttpServletRequest的信息
            HttpServletRequest request = (HttpServletRequest) requestAttributes
                    .resolveReference(RequestAttributes.REFERENCE_REQUEST);
            // 如果要获取Session信息的话，可以这样写：
            // HttpSession session = (HttpSession)
            // requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);

            Object[] requestParams = joinPoint.getArgs();
            JSONArray requestJson = new JSONArray();
            for (int i = 0; i < requestParams.length; i++) {
                if (requestParams[i].getClass().equals(org.apache.catalina.connector.RequestFacade.class) ||
                        requestParams[i].getClass().equals(org.apache.catalina.connector.ResponseFacade.class)) {
                    continue;
                }
                requestJson.add(requestParams[i]);
            }
            JsonResult respJson = (JsonResult) keys;
            log.info(request.getMethod() + ":" + signature.toShortString() + "参数报文：" + JSONObject.toJSONString(requestJson));
            log.info(request.getMethod() + ":" + signature.toShortString() + "返回报文：" + JSONObject.toJSONString(respJson));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @Pointcut("execution(* loan.web..*.*(..))")
    public void executeService() {

    }

    /**
     * 前置通知，方法调用前被调用
     *
     * @param joinPoint
     */
    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        try {
            Signature signature = joinPoint.getSignature();
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            // 从获取RequestAttributes中获取HttpServletRequest的信息
            HttpServletRequest request = (HttpServletRequest) requestAttributes
                    .resolveReference(RequestAttributes.REFERENCE_REQUEST);
            Object[] requestParams = joinPoint.getArgs();
            JSONArray vo = new JSONArray();
            for (int i = 0; i < requestParams.length; i++) {
                if (requestParams[i].getClass().equals(org.apache.catalina.connector.RequestFacade.class)) {
                    continue;
                }
                vo.add(requestParams[i]);
            }
            log.info(request.getMethod() + ":" + signature.toShortString() + vo.toJSONString());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    // @AfterReturning(value = "execution(* com.xu.demo.web..*.*(..))",returning
    // = "keys",argNames = "keys")
    // public void doAfterReturningAdvice2(String keys){
    //
    // System.out.println("第二个后置返回通知的返回值："+keys);
    // }

    /**
     * 后置异常通知 定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     * throwing 限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     * 对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     *
     * @param joinPoint
     * @param exception
     */
    // @Around("execution(* com.xiaoma.platform.controller..*.testAround*(..))")
    // public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
    // System.out.println("环绕通知的目标方法名："+proceedingJoinPoint.getSignature().getName());
    // try {
    // Object obj = proceedingJoinPoint.proceed();
    // return obj;
    // } catch (Throwable throwable) {
    // throwable.printStackTrace();
    // }
    // return null;
    // }

    /**
     * 后置最终通知（目标方法只要执行完了就会执行后置通知方法）
     *
     * @param joinPoint
     */
    // @After("executeService()")
    // public void doAfterAdvice(JoinPoint joinPoint){
    //// System.out.println("后置通知执行了!!!!");
    // }

    /**
     * 环绕通知： 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    // @Around("execution(* com.xiaoma.platform.controller..*.testAround*(..))")
    // public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
    // System.out.println("环绕通知的目标方法名："+proceedingJoinPoint.getSignature().getName());
    // try {
    // Object obj = proceedingJoinPoint.proceed();
    // return obj;
    // } catch (Throwable throwable) {
    // throwable.printStackTrace();
    // }
    // return null;
    // }
}