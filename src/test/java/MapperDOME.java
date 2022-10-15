import com.stx.inter.mybatisMapper;
import com.stx.pojo.mybatisTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MapperDOME {
    public static void main(String[] args) throws IOException {
//        1.加载mybatis的核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        3.获取接口代理
        mybatisMapper mapper = sqlSession.getMapper(mybatisMapper.class);

//       4. 使用代理运行语句
        List<mybatisTest> mybatisTests = mapper.selectAll();
        System.out.println(mybatisTests);

//        4.释放资源
        sqlSession.close();


    }
}
