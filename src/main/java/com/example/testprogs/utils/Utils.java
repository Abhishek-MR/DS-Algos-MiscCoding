package com.example.testprogs.utils;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Utils {
    public static ObjectMapper omap = new ObjectMapper();

    public static boolean fileExists(String dirPrefix, String filename){
        return fileExists(new File(dirPrefix, filename));
    }

    public static boolean fileExists(String filename){
        return fileExists(new File(filename));
    }

    public static boolean fileExists(File filename){
        return filename.exists();
    }

    public static boolean removeFile(String filename) {
        return removeFile(new File(filename));
    }

    public static boolean removeFile(File filename) {
        try{
            return filename.delete();
        }catch (Exception e){
        }
        return false;
    }

    public static boolean removeDir(String filename){
        return removeDir(new File(filename));
    }

    public static boolean removeDir(File filename) {
        try{
            if(filename.isDirectory()){
                File[] filelist = filename.listFiles();
                for(File file: filelist){
                    boolean isDeleted ;
                    if(file.isDirectory())
                        isDeleted = removeDir(file);
                    else
                        isDeleted = file.delete();
                    if(isDeleted != true)
                        return false;
                }
            }
            return filename.delete();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }



    public static String getPropertyL2(HashMap<String, String> properties, String propL2) {
        if (properties != null && properties.containsKey(propL2)) {
            return properties.get(propL2);
        }
        return null;
    }

    public static HashMap<String, String> getProperty(HashMap<String, HashMap<String, String>> properties,
                                                      String propL1){
        if (properties != null && properties.containsKey(propL1))
            return properties.get(propL1);
        return null;
    }
    public static String getProperty(HashMap<String, HashMap<String, String>> properties, String propL1, String propL2) {
        HashMap<String, String> propertiesL1 = getProperty(properties, propL1);
        if (propertiesL1 != null && propertiesL1.containsKey(propL2)) {
            return propertiesL1.get(propL2);
        }
        return null;
    }

    public static boolean makeDirectory(String dirName){
        File dirFile = new File(dirName);
        if (dirFile.exists())
            return true;
        try{
            dirFile.mkdirs();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static Logger createLogger(String loggerName, String scratchDir, String loggerFileName) {
	return createLogger(loggerName, scratchDir, loggerFileName, 5);
    }
    public static Logger createLogger(String loggerName, String scratchDir, String loggerFileName, int numFilesToRetain) {
        Logger logger = Logger.getLogger(loggerName);
        try {
            String logDirectory = osPathCombine(scratchDir, "logs");
            Utils.makeDirectory(logDirectory);
            String logFilePath = osPathCombine(logDirectory, loggerFileName + ".log");
            new File(logDirectory).mkdirs();
            FileHandler fh = new FileHandler(logFilePath, 10 * 1024 * 1024, numFilesToRetain, true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        logger.info(loggerName + " created");
        return logger;
    }

    public static String longToMySQLdatetime(long reqtime) {
        java.util.Date dt = new java.util.Date(reqtime);
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        return currentTime;
    }

    public static String osPathCombine(String path1, String path2) {
        File file1 = new File(path1);
        File file2 = new File(file1, path2);
        return file2.getPath();
    }

    public static String objToJsonPrettyStr(Object reqObj, Logger logger) {
        omap.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        ObjectWriter ow = omap.writer().withDefaultPrettyPrinter();
//        ObjectWriter ow = omap.writer();
        try {
            StringWriter stringWriter = new StringWriter();
            ow.writeValue(stringWriter, reqObj);
            return stringWriter.toString();
        }catch (Exception e){
            logger.log(Level.SEVERE, "JSON Conversion Failed", e);
        }
        return null;
    }

    public static JsonNode arrayListTOJSONS(ArrayList<String> inpList){
        ArrayNode objNode = omap.createArrayNode();
        for(String eachElement: inpList){
            objNode.add(eachElement);
        }
        return objNode;
    }

    public static JsonNode hashSetToJSONI(HashSet<Integer> inpSet){
        ArrayNode objNode = omap.createArrayNode();
        for(Integer eachElement: inpSet){
            objNode.add(eachElement);
        }
        return objNode;
    }

    public static JsonNode hashSetToJSONL(HashSet<Long> inpSet){
        ArrayNode objNode = omap.createArrayNode();
        for(Long eachElement: inpSet){
            objNode.add(eachElement);
        }
        return objNode;
    }

    public static JsonNode hashSetToJSONS(HashSet<String> inpSet){
        ArrayNode objNode = omap.createArrayNode();
        for(String eachElement: inpSet){
            objNode.add(eachElement);
        }
        return objNode;
    }


    public static JsonNode hashMapToJSONII(HashMap<Integer, Integer> inpMatrix){
        ObjectNode objNode = omap.createObjectNode();
        for(HashMap.Entry<Integer, Integer> eachEntry: inpMatrix.entrySet()){
            objNode.put(Integer.toString(eachEntry.getKey()), eachEntry.getValue());
        }
        return objNode;
    }

    public static JsonNode hashMapToJSONSII(HashMap<String, HashMap<Integer, Integer>> inpMatrix){
        ObjectNode objNode = omap.createObjectNode();
        for(HashMap.Entry<String, HashMap<Integer, Integer>> outerEntry: inpMatrix.entrySet()) {
            ObjectNode innerObjectNode = omap.createObjectNode();
            for (HashMap.Entry<Integer, Integer> innerEntry : outerEntry.getValue().entrySet()) {
                innerObjectNode.put(Integer.toString(innerEntry.getKey()), innerEntry.getValue());
            }
            objNode.put(outerEntry.getKey(), innerObjectNode);
        }
        return objNode;
    }

    public static <T> HashSet<T> copyHashset(HashSet<T> inpSet){
        HashSet<T> copy = new HashSet<>(inpSet);
        return copy;
    }

    public static HashMap<Integer, Long> copyHashIL(HashMap<Integer, Long> inpMatrix){
        HashMap<Integer, Long> newMatrix = new HashMap<>();
        for(HashMap.Entry<Integer, Long> eachEntry: inpMatrix.entrySet()){
            newMatrix.put(eachEntry.getKey(), eachEntry.getValue());
        }
        return newMatrix;
    }

    public static HashMap<String, HashMap<Integer, Long>> copyHashHashSIL(
            HashMap<String, HashMap<Integer, Long>> inpMatrix){
        HashMap<String, HashMap<Integer, Long>> newMatrix = new HashMap<>();
        for(HashMap.Entry<String, HashMap<Integer, Long>> outerEntry: inpMatrix.entrySet()){
            String key1 = outerEntry.getKey();
            HashMap<Integer, Long> innerMatrix = new HashMap<>();
            for(HashMap.Entry<Integer, Long> innerEntry: outerEntry.getValue().entrySet()){
                innerMatrix.put(innerEntry.getKey(), innerEntry.getValue());
            }
            newMatrix.put(key1, innerMatrix);
        }
        return newMatrix;
    }

    public static JsonNode hashMapToJSONSIL(HashMap<String, HashMap<Integer, Long>> inpMatrix){
        ObjectNode objNode = omap.createObjectNode();
        for(HashMap.Entry<String, HashMap<Integer, Long>> outerEntry: inpMatrix.entrySet()) {
            ObjectNode innerObjectNode = omap.createObjectNode();
            for (HashMap.Entry<Integer, Long> innerEntry : outerEntry.getValue().entrySet()) {
                innerObjectNode.put(Integer.toString(innerEntry.getKey()), innerEntry.getValue());
            }
            objNode.put(outerEntry.getKey(), innerObjectNode);
        }
        return objNode;
    }

    public static JsonNode hashMapToJSONSS(HashMap<String, String> inpMatrix){
        ObjectNode objNode = omap.createObjectNode();
        for(HashMap.Entry<String, String> eachEntry: inpMatrix.entrySet()){
            objNode.put(eachEntry.getKey(), eachEntry.getValue());
        }
        return objNode;
    }

    public static JsonNode hashMapToJSONLI(HashMap<Long, Integer> inpMatrix){
        ObjectNode objNode = omap.createObjectNode();
        for(HashMap.Entry<Long, Integer> eachEntry: inpMatrix.entrySet()){
            objNode.put(Long.toString(eachEntry.getKey()), eachEntry.getValue());
        }
        return objNode;
    }

    public static JsonNode hashMapToJSONIL(HashMap<Integer, Long> inpMatrix){
        ObjectNode objNode = omap.createObjectNode();
        for(HashMap.Entry<Integer, Long> eachEntry: inpMatrix.entrySet()){
            objNode.put(Integer.toString(eachEntry.getKey()), eachEntry.getValue());
        }
        return objNode;
    }

    public static JsonNode hashMapToJSONSL(HashMap<String, Long> inpMatrix){
        ObjectNode objNode = omap.createObjectNode();
        for(HashMap.Entry<String, Long> eachEntry: inpMatrix.entrySet()){
            objNode.put(eachEntry.getKey(), eachEntry.getValue());
        }
        return objNode;
    }

    public static JsonNode hashMapToJSONSI(HashMap<String, Integer> inpMatrix){
        ObjectNode objNode = omap.createObjectNode();
        for(HashMap.Entry<String, Integer> eachEntry: inpMatrix.entrySet()){
            objNode.put(eachEntry.getKey(), eachEntry.getValue());
        }
        return objNode;
    }

    public static JsonNode hashMapToJSONIS(HashMap<Integer, String> inpMatrix){
        ObjectNode objNode = omap.createObjectNode();
        for(HashMap.Entry<Integer, String> eachEntry: inpMatrix.entrySet()){
            objNode.put(eachEntry.getKey().toString(), eachEntry.getValue());
        }
        return objNode;
    }

    public static JsonNode hashMapToJSONShS(HashMap<Short, String> inpMatrix){
        ObjectNode objNode = omap.createObjectNode();
        for(HashMap.Entry<Short, String> eachEntry: inpMatrix.entrySet()){
            objNode.put(eachEntry.getKey().toString(), eachEntry.getValue());
        }
        return objNode;
    }

    public static String objToJSONStr(Object reqObj, Logger logger) {
        omap.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        //ObjectWriter ow = omap.writer().withDefaultPrettyPrinter();
        ObjectWriter ow = omap.writer();
        try {
            StringWriter stringWriter = new StringWriter();
            ow.writeValue(stringWriter, reqObj);
            return stringWriter.toString();
        }catch (Exception e){
            logger.log(Level.SEVERE, "JSON Conversion Failed", e);
        }
        return null;
    }

    static DecimalFormat df;
    static  {
        df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.CEILING);
    }
    public static String decimalToString(double inputno){
        return df.format(inputno);
    }


    public static HashMap<String, HashMap<String, String>> readConfig(String configFilePath) {
        HashMap<String, HashMap<String, String>> configProperties = new HashMap<String, HashMap<String, String>>();
        try {
            File configFile = new File(configFilePath);
            if (configFile.isFile() && configFile.exists()) {
                BufferedReader binp = new BufferedReader(new FileReader(configFile));
                String line;
                while ((line = binp.readLine()) != null) {
                    String propertiesSplit[] = line.split("=", 2);
                    if (propertiesSplit.length == 2) {
                        String propertyType[] = propertiesSplit[0].split("\\.", 2);
                        if (propertyType.length == 2) {
                            if (!configProperties.containsKey(propertyType[0]))
                                configProperties.put(propertyType[0], new HashMap<String, String>());
                            configProperties.get(propertyType[0]).put(propertyType[1], propertiesSplit[1]);
                        }
                    }
                }
            }
        } catch (Exception e) {

        }

        return configProperties;
    }

    public static int readS32(byte[] inputBeacon, int startFrom) {
        int result = inputBeacon[startFrom + 3] & 0x000000ff;
        result = ((result << 8) & 0xffffff00) + (inputBeacon[startFrom + 2] & 0x000000ff);
        result = ((result << 8) & 0xffffff00) + (inputBeacon[startFrom + 1] & 0x000000ff);
        result = ((result << 8) & 0x00000000ffffff00) + (inputBeacon[startFrom] & 0x000000ff);
        return result;
    }

    public static int writeS32(byte[] outputBeacon, int startFrom, int intToWrite) {
        outputBeacon[startFrom] = (byte) (intToWrite & 0xff);
        outputBeacon[startFrom + 1] = (byte) ((intToWrite >> 8) & 0xff);
        outputBeacon[startFrom + 2] = (byte) ((intToWrite >> 16) & 0xff);
        outputBeacon[startFrom + 3] = (byte) ((intToWrite >> 24) & 0xff);
        return 4;
    }

    private static int hexToBin(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        }
        if ('A' <= ch && ch <= 'F') {
            return ch - 'A' + 10;
        }
        if ('a' <= ch && ch <= 'f') {
            return ch - 'a' + 10;
        }
        return -1;
    }

    public static byte[] parseHexBinary(String s, int startFrom){
        final int len = s.length() - startFrom ;

        // "111" is not a valid hex encoding.
        if (len % 2 != 0) {
            throw new IllegalArgumentException("hexBinary needs to be even-length: " + s);
        }

        byte[] out = new byte[len / 2];

        int pos = 0;
        for (int i = 0; i < len; i += 2) {
            int h = hexToBin(s.charAt(i + startFrom));
            int l = hexToBin(s.charAt(i + startFrom + 1));
            if (h == -1 || l == -1) {
                throw new IllegalArgumentException("contains illegal character for hexBinary: " + s);
            }

            out[pos] = (byte) (h * 16 + l);
            pos++;
        }

        return out;
    }

    public static int sizeOf(byte element){
        return 1;
    }

    public static int sizeOf(short element){
        return 2;
    }

    public static int sizeOf(int element){
        return 4;
    }

    public static int sizeOf(long element){
        return 8;
    }

    public static int sizeOf(float element){
        return 4;
    }

    public static int sizeOf(double element){
        return 8;
    }

    //Its actually VM dependent. In most of the cases its 10
    public static int sizeOf(boolean element) {return  10 ;}
}
