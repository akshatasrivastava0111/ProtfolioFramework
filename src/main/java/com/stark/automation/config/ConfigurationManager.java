package com.stark.automation.config;
import com.stark.automation.core.exceptions.ConfigurationException;
import java.io.InputStream; import java.util.Properties;
public final class ConfigurationManager {
  private static final Properties PROPERTIES = load();
  private ConfigurationManager() { }
  private static Properties load() { String env = System.getProperty("env", "qa"); String resource = "config/" + env + ".properties"; try (InputStream input = ConfigurationManager.class.getClassLoader().getResourceAsStream(resource)) { if (input == null) throw new ConfigurationException("Unknown environment '" + env + "'. Expected qa, staging, or production."); Properties values = new Properties(); values.load(input); return values; } catch (ConfigurationException e) { throw e; } catch (Exception e) { throw new ConfigurationException("Unable to load " + resource, e); } }
  public static String value(String key) { String result = System.getProperty(key, PROPERTIES.getProperty(key)); if (result == null || result.isBlank()) throw new ConfigurationException("Missing required configuration: " + key); return result; }
  public static int integer(String key) { try { return Integer.parseInt(value(key)); } catch (NumberFormatException e) { throw new ConfigurationException("Configuration '" + key + "' must be an integer.", e); } }
  public static boolean flag(String key) { return Boolean.parseBoolean(value(key)); }
  public static String environment() { return System.getProperty("env", "qa"); }
}
