package boot.spring.config;

import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author phw
 * @date Created in 05-09-2018
 * @description
 */
@Configuration
public class ActivitiConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ResourcePatternResolver resourceLoader;

    /**

     * 初始化配置，将创建28张表

     * @return

     */

    @Bean
    public StandaloneProcessEngineConfiguration processEngineConfiguration() {

        StandaloneProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();

        configuration.setDataSource(dataSource);

        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        configuration.setAsyncExecutorActivate(false);

        return configuration;

    }

    @Bean
    public ProcessEngine processEngine() {

        return processEngineConfiguration().buildProcessEngine();

    }

    @Bean
    public RepositoryService repositoryService() {

        return processEngine().getRepositoryService();

    }

    @Bean

    public RuntimeService runtimeService() {

        return processEngine().getRuntimeService();

    }

    @Bean

    public TaskService taskService() {

        return processEngine().getTaskService();

    }

    @Bean

    public HistoryService historyService() {

        return processEngine().getHistoryService();

    }
    @Bean

    public FormService formService() {

        return processEngine().getFormService();

    }

    @Bean
    public IdentityService identityService(){
        return processEngine().getIdentityService();
    }


}

