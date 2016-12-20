package be.vdab.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import be.vdab.entities.JobtitelTest;
import be.vdab.entities.WerknemerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({JobtitelTest.class, WerknemerTest.class})
public class EntitiesSuite {
}