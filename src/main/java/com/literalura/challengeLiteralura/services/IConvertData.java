package com.literalura.challengeLiteralura.services;

public interface IConvertData {

    <T> T getData(String json, Class<T> clase);
}
