import com.JavaTests.config.DataConfig;
import com.JavaTests.repository.TestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { DataConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class MainTest {

    @Resource
    private TestRepository testRepository;

    @Test
    public void givenStudent_whenSave_thenGetOk() {
        com.JavaTests.entity.Test test = new com.JavaTests.entity.Test("Ruby");
        testRepository.save(test);

//        com.JavaTests.entity.Test test2 = testRepository.findOne(2);
//        Assert.assertEquals("Ruby", test2.getName());
    }
}
