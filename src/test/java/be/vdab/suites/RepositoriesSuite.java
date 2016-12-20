package be.vdab.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import be.vdab.repositories.JobtitelRepositoryTest;
import be.vdab.repositories.WerknemerRepositoryTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({JobtitelRepositoryTest.class, WerknemerRepositoryTest.class})
public class RepositoriesSuite {
}