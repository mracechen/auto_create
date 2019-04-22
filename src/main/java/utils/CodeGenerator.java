package utils;

import com.google.common.base.CaseFormat;
import freemarker.template.TemplateExceptionHandler;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CodeGenerator {
    /**
     * JDBC配置，请修改为你项目的实际配置
     */
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jys?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "aaa000000";
    private static final String JDBC_DIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    /**
     * 模块名称
     */
    static final String MODULE_NAME = "";
    /**
     * 模块路径
     */
    static final String MODULE_DIR = "" + CodeGenerator.MODULE_NAME;
    /**
     * 模块基础路径
     */
    public static final String BASE_PACKAGE = "com.jys.user" + CodeGenerator.MODULE_NAME;
    /**
     * Model所在包
     */
    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";
    /**
     * Mapper所在包
     */
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";

    /**
     * Mapper插件基础接口的完全限定名
     */
    public static final String MAPPER_INTERFACE_REFERENCE = "com.common.BaseMapper";
    /**
     * 项目在硬盘上的基础路径
     */
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    /**
     * 模板位置
     */
    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/main/resources/templates";
    /**
     * java文件路径
     */
    private static final String JAVA_PATH = MODULE_DIR + "/src/main/java/";
    /**
     * 资源文件路径
     */
    private static final String RESOURCES_PATH = MODULE_DIR + "/src/main/resources";
    /**
     * 生成的Service存放路径
     */
    private static final String PACKAGE_PATH_SERVICE = "/com/jys/user/" + CodeGenerator.MODULE_NAME + "/service/";
    /**
     * 生成的Service实现存放路径
     */
    private static final String PACKAGE_PATH_SERVICE_IMPL = "/com/jys/user/" + CodeGenerator.MODULE_NAME + "/service/impl/";
    /**
     * 生成的Controller存放路径
     */
    private static final String PACKAGE_PATH_CONTROLLER = "/com/jys/user/" + CodeGenerator.MODULE_NAME + "/controller/";
    /**
     * 生成的RequestVO存放路径
     */
    private static final String PACKAGE_PATH_REQUESTVO = "/com/jys/user/" + CodeGenerator.MODULE_NAME + "/vo/request/";
    /**
     * 生成的ResponseVO存放路径
     */
    private static final String PACKAGE_PATH_RESPONSEVO = "/com/jys/user/" + CodeGenerator.MODULE_NAME + "/vo/response/";
    /**
     * 生成的EntityVO存放路径
     */
    private static final String PACKAGE_PATH_ENTITYVO = "/com/jys/user/" + CodeGenerator.MODULE_NAME + "/vo/entity/";

    private static final String AUTHOR = "chenjie";
    private static final String DATE = new SimpleDateFormat("yyyy/MM/dd").format(new Date());



    /**
     * 通过数据表名称生成代码，Model 名称通过解析数据表名称获得，下划线转大驼峰的形式。
     * 如输入表名称 "t_user_detail" 将生成 TUserDetail、TUserDetailMapper、TUserDetailService ...
     * @param tableNames 数据表名称...
     */
    public static void genCode(String... tableNames) {
        for (String tableName : tableNames) {
            genCode(tableName, null);
        }
    }

    /**
     * 通过数据表名称，和自定义的 Model 名称生成代码
     * 如输入表名称 "t_user_detail" 和自定义的 Model 名称 "User" 将生成 User、UserMapper、UserService ...
     * @param tableName 数据表名称
     * @param modelName 自定义的 Model 名称
     */
    public static void genCode(String tableName, String modelName) {
        File file1 = new File(PROJECT_PATH + JAVA_PATH);
        File file2 = new File(PROJECT_PATH + RESOURCES_PATH);
        if (!file1.getAbsoluteFile().exists()) {
            file1.getAbsoluteFile().mkdirs();
        }
        if (!file2.getAbsoluteFile().exists()) {
            file2.getAbsoluteFile().mkdirs();
        }
        //(tableName, modelName);
        genController(tableName, modelName);
        genService(tableName, modelName);
        genModelAndMapper(tableName, modelName);
        genEntityVO(tableName,modelName);
        genRequestVO(tableName,modelName);
        genResponseVO(tableName,modelName);
    }


    public static void genModelAndMapper(String tableName, String modelName) {
        /*MybatisGenerate1 app = new MybatisGenerate1();
        System.out.println(app.getClass().getResource("/").getPath());
        try{
            app.generator();
            System.out.println(System.getProperty("user.dir"));
        }catch (Exception e){

        }*/

        Context context = new Context(ModelType.FLAT);
        context.setId("chn");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");

        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(JDBC_URL);
        jdbcConnectionConfiguration.setUserId(JDBC_USERNAME);
        jdbcConnectionConfiguration.setPassword(JDBC_PASSWORD);
        jdbcConnectionConfiguration.setDriverClass(JDBC_DIVER_CLASS_NAME);
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
        pluginConfiguration.addProperty("mappers", CodeGenerator.MAPPER_INTERFACE_REFERENCE);
        context.addPluginConfiguration(pluginConfiguration);

        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaModelGeneratorConfiguration.setTargetPackage(CodeGenerator.MODEL_PACKAGE);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(PROJECT_PATH + RESOURCES_PATH);
        sqlMapGeneratorConfiguration.setTargetPackage("Mapper");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaClientGeneratorConfiguration.setTargetPackage(CodeGenerator.MAPPER_PACKAGE);
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        tableConfiguration.setDomainObjectName(modelName);
        tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
        context.addTableConfiguration(tableConfiguration);

        List<String> warnings;
        MyBatisGenerator generator;
        try {
            Configuration config = new Configuration();
            config.addContext(context);
            config.validate();

            boolean overwrite = true;
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            warnings = new ArrayList<String>();
            generator = new MyBatisGenerator(config, callback, warnings);
            generator.generate(null);
        } catch (Exception e) {
            throw new RuntimeException("生成Model和Mapper失败", e);
        }

        if (generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
            throw new RuntimeException("生成Model和Mapper失败：" + warnings);
        }
        if (StringUtils.isEmpty(modelName)){
            modelName = tableNameConvertUpperCamel(tableName);
        }
        System.out.println(modelName + ".java 生成成功");
        System.out.println(modelName + "Mapper.java 生成成功");
        System.out.println(modelName + "Mapper.xml 生成成功");
    }

    public static void genService(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", CodeGenerator.BASE_PACKAGE);

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + modelNameUpperCamel + "Service.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("service.ftl").process(data,
                    new FileWriter(file));
            System.out.println(modelNameUpperCamel + "Service.java 生成成功");

            File file1 = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + modelNameUpperCamel + "ServiceImpl.java");
            if (!file1.getParentFile().exists()) {
                file1.getParentFile().mkdirs();
            }
            cfg.getTemplate("service-impl.ftl").process(data,
                    new FileWriter(file1));
            System.out.println(modelNameUpperCamel + "ServiceImpl.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Service失败", e);
        }
    }

    public static void genController(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            //
            String[] split = tableName.split("_");
            String tableLastName = split[1];
            //
            String modelLastName = firstToCapital(tableLastName);
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", CodeGenerator.BASE_PACKAGE);
            data.put("tableLastName", tableLastName);
            data.put("modelLastName", modelLastName);
            data.put("modelName", MODULE_NAME);

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + modelNameUpperCamel + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("controller.ftl").process(data, new FileWriter(file));

            System.out.println(modelNameUpperCamel + "Controller.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Controller失败", e);
        }

    }

    public static void genRequestVO(String tableName, String modelName) {
        genVO(tableName,modelName,PACKAGE_PATH_REQUESTVO,"RequestVO");

    }

    public static void genResponseVO(String tableName, String modelName) {
        genVO(tableName,modelName,PACKAGE_PATH_RESPONSEVO,"ResponseVO");
    }

    public static void genEntityVO(String tableName, String modelName) {
        genVO(tableName,modelName,PACKAGE_PATH_ENTITYVO,"EntityVO");
    }

    public static void genVO(String tableName, String modelName,String packagePath,String className) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            //
            List<BaseData> baseDataList = DatabaseUtil.getBaseDataList(tableName);
            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", CodeGenerator.BASE_PACKAGE);
            data.put("baseDataList", baseDataList);

            File file = new File(PROJECT_PATH + JAVA_PATH + packagePath + modelNameUpperCamel + className +".java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate(className +".ftl").process(data, new FileWriter(file));

            System.out.println(modelNameUpperCamel + className + ".java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException(className, e);
        }

    }

    private static freemarker.template.Configuration getConfiguration() throws IOException {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return cfg;
    }

    private static String tableNameConvertLowerCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName.toLowerCase());
    }

    private static String tableNameConvertUpperCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());

    }

    private static String tableNameConvertMappingPath(String tableName) {
        //兼容使用大写的表名
        tableName = tableName.toLowerCase();
        return "/" + (tableName.contains("_") ? tableName.replaceAll("_", "/") : tableName);
    }

    private static String modelNameConvertMappingPath(String modelName) {
        String tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, modelName);
        return tableNameConvertMappingPath(tableName);
    }

    private static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }

    //首字母大写
    private static String firstToCapital(String str){
        char[] chars = str.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = (char)(chars[0] - 32);
        }
        return new String(chars);
    }

}