

@Autowired 对类成员变量、方法及构造函数进行标注，完成自动装配的工作
@Service 标注业务层组件
@Controller 标注控制层组件
@Repository 标注数据访问层组件
@Component 泛指组件
@RequestMapping 处理请求地址的映射
@ResponseBody 将controller返回的对象处理后，写入到数据流
@Param 给参数命名
@PathVariable 将url中的占位符绑定到控制器处理方法的入参中
@RequestParam 将请求参数区的数据映射到功能处理方法的参数中
@Transactional 开启事务
@TransactionConfiguration 指定及设置事务管理的bean
@Configuration 定义配置类,相当与spring的xml配置文件
@RunWith 测试 运行器
@ContextConfiguration 测试 引入多个配置文件
@WebAppConfiguration 测试service层 指定加载applicationcontext是一个webapplicationcontext

如果没有带有参数的构造方法，无参的构造方法可以省略不写，否则一定要写上

dao定义操作数据库的各种接口
service定义业务接口，存在的意义就是被实现
impl实现业务接口，调用dao中的方法，使用@Service注解
