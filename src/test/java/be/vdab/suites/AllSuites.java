package be.vdab.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ControllerSuite.class, DataSourceSuite.class, EntitiesSuite.class, RepositoriesSuite.class})
public class AllSuites {
}