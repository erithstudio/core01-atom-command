/**
 * Copyright 2017, Denis Prasetio, Erith Studio
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License
 * at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.erith.core.atomcommand.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Debug {

    private static final Logger logger = LoggerFactory.getLogger(Debug.class);

    /***
     * Summary: Logs message to Console.
     *
     * Parameters:
     * @param message, String or Object to be converted to String representation for display.
     */
    public static void Log(Object message) {
        logger.info(String.valueOf(message));
    }

    /***
     * Summary: Logs message to Console.
     *
     * Parameters:
     * @param message, String or Object to be converted to String representation for display.
     * @param context, Object to which the message applies.
     */
    public static void Log(Object message, Object context) {
        logger.info(String.valueOf(message), context);
    }

    /***
     * Summary: A variant of Debug.Log that logs an assertion message to the console.
     *
     * Parameters:
     * @param message, String or Object to be converted to String representation for display.
     */
    public static void LogAssertion(Object message) {
        logger.trace(String.valueOf(message));
    }

    /***
     * Summary: A variant of Debug.Log that logs an assertion message to the console.
     *
     * Parameters:
     * @param context, Object to which the message applies.
     * @param message, String or Object to be converted to String representation for display.
     */
    public static void LogAssertion(Object message, Object context) {
        logger.trace(String.valueOf(message), context);
    }

    /***
     * Summary: Logs a formatted assertion message to console.
     *
     * Parameters:
     * @param format, A composite format string.
     * @param args, Format arguments.
     */
    public static void LogAssertionFormat(String format, Object[] args) {
        logger.trace(String.format(format, args));
    }

    /***
     * Summary: Logs a formatted assertion message to console.
     *
     * Parameters:
     * @param context, Object to which the message applies.
     * @param format, A composite format string.
     * @param args, Format arguments.
     */
    public static void LogAssertionFormat(Object context, String format, Object[] args) {
        logger.trace(String.format(format, args), context);
    }

    /***
     * Summary: A variant of Debug.Log that logs an error message to the console.
     *
     * Parameters:
     * @param message, String or Object to be converted to String representation for display.
     */
    public static void LogError(Object message) {
        logger.error(String.valueOf(message));
    }

    /***
     * Summary: A variant of Debug.Log that logs an error message to the console.
     *
     * Parameters:
     * @param message, String or Object to be converted to String representation for display.
     * @param context, Object to which the message applies.
     */
    public static void LogError(Object message, Object context) {
        logger.error(String.valueOf(message), context);
    }

    /***
     * Summary: Logs a formatted error message to console.
     *
     * Parameters:
     * @param format, A composite format string.
     * @param args, Format arguments.
     */
    public static void LogErrorFormat(String format, Object[] args) {
        logger.error(String.format(format, args));
    }

    /***
     * Summary: Logs a formatted error message to console.
     *
     * Parameters:
     * @param context, Object to which the message applies.
     * @param format, A composite format string.
     * @param args, Format arguments.
     */
    public static void LogErrorFormat(Object context, String format, Object[] args) {
        logger.error(String.format(format, args), context);
    }

    /***
     * Summary: A variant of Debug.Log that logs an error message to the console.
     *
     * Parameters:
     * @param exception, Runtime Exception.
     */
    public static void LogException(Exception exception) {
        logger.error("Exception:", exception);
    }

    /***
     * Summary: A variant of Debug.Log that logs an error message to the console.
     *
     * Parameters:
     * @param context, Object to which the message applies.
     * @param exception, Runtime Exception.
     */
    public static void LogException(Exception exception, Object context) {
        logger.error(String.valueOf(context), exception);
    }

    /***
     * Summary: Logs a formatted message to Console.
     *
     * Parameters:
     * @param format, A composite format string.
     * @param args, Format arguments.
     */
    public static void LogFormat(String format, Object[] args) {
        logger.info(String.format(format, args));
    }

    /***
     * Summary: Logs a formatted message to Console.
     *
     * Parameters:
     * @param format, A composite format string.
     * @param args, Format arguments.
     * @param context, Object to which the message applies.
     */
    public static void LogFormat(Object context, String format, Object[] args) {
        logger.info(String.format(format, args), context);
    }

    /***
     * Summary: A variant of Debug.Log that logs a warning message to the console.
     *
     * Parameters:
     * @param message, String or Object to be converted to String representation for display.
     */
    public static void LogWarning(Object message) {
        logger.warn(String.valueOf(message));
    }

    /***
     * Summary: A variant of Debug.Log that logs a warning message to the console.
     *
     * Parameters:
     * @param message, String or Object to be converted to String representation for display.
     * @param context, Object to which the message applies.
     */
    public static void LogWarning(Object message, Object context) {
        logger.warn(String.valueOf(message), context);
    }

    /***
     * Summary: Logs a formatted warning message to Console.
     *
     * Parameters:
     * @param format, A composite format string.
     * @param args, Format arguments.
     */
    public static void LogWarningFormat(String format, Object[] args) {
        logger.warn(String.format(format, args));
    }

    /***
     * Summary: Logs a formatted warning message to Console.
     *
     * Parameters:
     * @param context, Object to which the message applies.
     * @param format, A composite format string.
     * @param args, Format arguments.
     */
    public static void LogWarningFormat(Object context, String format, Object[] args) {
        logger.warn(String.format(format, args), context);
    }
}
