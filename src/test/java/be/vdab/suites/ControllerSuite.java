package be.vdab.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import be.vdab.web.JobtitelControllerTest;
import be.vdab.web.OpslagControllerTest;
import be.vdab.web.WerknemerControllerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({JobtitelControllerTest.class, WerknemerControllerTest.class, OpslagControllerTest.class})
public class ControllerSuite {
}