package br.devshy.riotgiftproxy.exception;

public class HydraAuthFailedException extends RuntimeException {
    public HydraAuthFailedException(String message) {
        super(message);
    }
}
