# KPI_Use

各种问题和解决方式

 1.@RestControllerAdvice @ControllerAdvice注解无效 通用异常处理
  原因
  将GlobalExceptionHandler定义在另一个包里面，@SpringBootApplication无法自动加载到该注解
  解决方式
  启动类的默认扫描路径是该类所在的包下面的所有java类，加上scanBasePackages参数
  @SpringBootApplication(scanBasePackages = {"com.alpinetech.*"})
