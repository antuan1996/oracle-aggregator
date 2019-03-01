import io.university.service.DepartmentFactory;
import model.dao.Department;
import org.junit.Assert;
import org.junit.Test;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 18.02.2019
 */
public class Tester extends Assert {

    @Test
    public void test() {
        DepartmentFactory factory = new DepartmentFactory();
        Department department = factory.build();
        assertNotNull(department);
    }
}
