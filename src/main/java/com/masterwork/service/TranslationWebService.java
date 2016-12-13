package com.masterwork.service;


import java.util.List;

/**
 * Uses abstract web.service
 */
public interface TranslationWebService {

    List<String> translateViaWebService(String firstEquivalent);
}
