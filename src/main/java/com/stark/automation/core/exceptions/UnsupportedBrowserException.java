package com.stark.automation.core.exceptions;
public class UnsupportedBrowserException extends RuntimeException { public UnsupportedBrowserException(String browser) { super("Unsupported browser: " + browser + ". Use chrome, firefox, or edge."); } }
