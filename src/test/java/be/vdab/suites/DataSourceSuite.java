package be.vdab.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import be.vdab.datasource.DataSourceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({DataSourceTest.class})
public class DataSourceSuite {
}