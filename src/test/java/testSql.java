import com.DevGroup114514.dao.sqlUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @Description: test
 * @ClassName: testSql
 * @Author: Edge
 * @Date: 2024/7/5 20:21
 * @Version: 1.0
 */
public class testSql
{
    @Test
    public void test()
    {
        try
        {
            String sql = "SELECT * FROM user_table";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(sqlUtils.getDataSource());
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
            System.out.println(result);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
}
