package com.example.advanced.app.v5;

import com.example.advanced.trace.callback.TraceTemplate;
import com.example.advanced.trace.logtrace.LogTrace;
import com.example.advanced.trace.template.AbstractTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate traceTemplate;

    public OrderRepositoryV5(LogTrace trace) {
        this.traceTemplate = new TraceTemplate(trace);
    }

    public void save(String itemId) {
        traceTemplate.excute("OrderRepository.save()", () -> {
            //저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            return null;
        });
    }
    
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace(); }
    }
}
