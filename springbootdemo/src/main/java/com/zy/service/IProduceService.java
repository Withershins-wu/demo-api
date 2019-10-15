package com.zy.service;

import javax.jms.Destination;

public interface IProduceService {
    void sendMessage(Destination destination, final String message);
}
