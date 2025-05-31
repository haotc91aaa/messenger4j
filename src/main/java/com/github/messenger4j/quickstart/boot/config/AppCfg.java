package com.github.messenger4j.quickstart.boot.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @author haotc
 */
public class AppCfg {
    private static final String ORDER_PROPERTIES_FILE_NAME = "file:config/application.properties";
    private static final Properties props = new Properties();


    static {
        loadProps();
    }

    /**
     * Load up the order properties. Right now the order properties is a simple
     * .properties file with name value pairs. It may evolve to become an XML
     * file later on.
     */
    public static void loadProps() {
        try {
			/*InputStream is = PropertyManager.class
					.getResourceAsStream(ORDER_PROPERTIES_FILE_NAME);*/

            File f = null;
            f = new File(new URL(ORDER_PROPERTIES_FILE_NAME).getFile());
            InputStream is = new FileInputStream(f);
            props.load(is);
        } catch (IOException ioe) {
        }
    }

    /**
     * Returns the value of a property for a given name. Any whitespace is
     * trimmed off the beginning and end of the property value. A runtime
     * exception is thrown if the property cannot be found.
     *
     * @param name
     *            the name of the requested property
     * @return value the value of the property matching the requested name
     */
    public static String getProperty(String name) {
        String val = props.getProperty(name);
        if (val == null)
            throw new RuntimeException("Property " + name + " not found!");
        else
            val = val.trim();
        return val;
    }

    /**
     * Returns the value of a property for a given name. This method can be used
     * if the property is boolean in nature and you want to make sure that
     * <code>true</code> is returned if the property is set to "true", "yes",
     * "y", or "on" (regardless of case), and <code>false</code> is returned in
     * all other cases.
     *
     * @param name
     *            the name of the requested property
     * @return value <code>true</code> if property is set to "true", "yes", "y",
     *         or "on" regardless of case, otherwise <code>false</code>
     */
    public static boolean getPropertyAsBoolean(String name) {
        boolean retValue = false;
        String value = getProperty(name);
        if (value != null) {
            if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("yes")
                    || value.equalsIgnoreCase("y")
                    || value.equalsIgnoreCase("on"))
                retValue = true;
        }
        return retValue;
    }

    /**
     * Returns the value of a property for a given name as a <code>byte</code>
     *
     * @param name
     *            the name of the requested property
     * @return value the property's value as a <code>byte</code>
     */
    public static byte getPropertyAsByte(String name) {
        return Byte.parseByte(getProperty(name));
    }

    /**
     * Returns the value of a property for a given name as a <code>short</code>
     *
     * @param name
     *            the name of the requested property
     * @return value the property's value as a <code>short</code>
     */
    public static short getPropertyAsShort(String name) {
        return Short.parseShort(getProperty(name));
    }

    /**
     * Returns the value of a property for a given name as an <code>int</code>
     *
     * @param name
     *            the name of the requested property
     * @return value the property's value as an <code>int</code>
     */
    public static int getPropertyAsInt(String name) {
        return Integer.parseInt(getProperty(name));
    }

    /**
     * Returns the value of a property for a given name as a <code>long</code>
     *
     * @param name
     *            the name of the requested property
     * @return value the property's value as a <code>long</code>
     */
    public static long getPropertyAsLong(String name) {
        return Long.parseLong(getProperty(name));
    }

    /**
     * Returns the value of a property for a given name as a <code>float</code>
     *
     * @param name
     *            the name of the requested property
     * @return value the property's value as a <code>float</code>
     */
    public static float getPropertyAsFloat(String name) {
        return Float.parseFloat(getProperty(name));
    }

    /**
     * Returns the value of a property for a given name as a <code>long</code>
     *
     * @param name
     *            the name of the requested property
     * @return value the property's value as a <code>long</code>
     */
    public static double getPropertyAsDouble(String name) {
        return Double.parseDouble(getProperty(name));
    }
}
