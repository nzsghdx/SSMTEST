###常用注解

`@Autowired` 对类成员变量、方法及构造函数进行标注，完成自动装配的工作

`@Service` 标注业务层组件

`@Controller` 标注控制层组件

`@Repository` 标注数据访问层组件

`@Component` 泛指组件

`@RequestMapping` 处理请求地址的映射

`@ResponseBody` 将controller返回的对象处理后，写入到数据流

`@Param` 给参数命名

`@PathVariable` 将url中的占位符绑定到控制器处理方法的入参中

`@RequestParam` 将请求参数区的数据映射到功能处理方法的参数中

`@Transactional` 开启事务

`@TransactionConfiguration` 指定及设置事务管理的bean

`@Configuration` 定义配置类,相当与spring的xml配置文件

`@RunWith` 测试 运行器

`@ContextConfiguration` 测试 引入多个配置文件

`@WebAppConfiguration` 测试service层 指定加载applicationcontext是一个webapplicationcontext


###注意事项

如果没有带有参数的构造方法，无参的构造方法可以省略不写，否则一定要写上

dao定义操作数据库的各种接口

service定义业务接口，存在的意义就是被实现

impl实现业务接口，调用dao中的方法，使用@Service注解

dto 用于service和web层之间的传输，用来存储返回的结果

web编写controller代码，控制数据传输和页面跳转


###项目结构

src主文件夹下包含main和test，分别是源码和测试代码文件夹

main下包括java，resource，webapp三个文件夹，分别是源码，配置文件，页面

test一般包含个java测试源码层就好

resource一般包括spring配置文件夹，mapper操作sql文件夹，mybatis-config和jdbc及log等配置文件

###项目逻辑

设置项目结构

其他设置（git/github,maven,jdk,compile等）

编写配置文件（spring，mybatis，springmvc，jdbc，log，pom,web.xml等）

编写bean

编写dao

编写mapper

编写数据访问层测试代码

编写service

实现service

编写业务层测试代码

编写web层（包括dto，enums等）

编写表示层测试代码

正式Coding

###业务逻辑




###常见问题



###Spring配置

