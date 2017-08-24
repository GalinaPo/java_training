package ru.stqa.pft.addressbook.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by gpodmorina on 23.08.2017.
 */
@CucumberOptions(features = "classpath:bdd", plugin = {"pretty", "html:build/cucumber-report"})
public class GroupTests extends AbstractTestNGCucumberTests {
}
