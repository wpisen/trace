package test.collects.servlet;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;
import org.junit.Test;

import com.wpisen.trace.agent.core.AgentItemSource;

import java.io.IOException;
import java.util.List;

/**
 * Created by wpisen on 16/11/12.
 */
public class ServletHandleTest extends BasiceTest{
    @Test
    public void buildServletClassTest() throws IOException, CannotCompileException, NotFoundException {
        String className = "javax.servlet.http.HttpServlet";
        List<AgentItemSource> list=new CollectItemBuildFactory().createServletItems();
        for(AgentItemSource i:list){
            i.setSrcTemplate(getSrc(i.getSrcTemplate()));
        }
        CtClass cla = loader.buildAgentClass(className, getClass().getClassLoader(), list);
        System.out.println(cla.toClass().getName());
    }
}
