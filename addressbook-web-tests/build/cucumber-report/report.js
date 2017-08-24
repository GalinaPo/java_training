$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("bdd/groups.feature");
formatter.feature({
  "line": 1,
  "name": "Groups",
  "description": "",
  "id": "groups",
  "keyword": "Feature"
});
formatter.before({
  "duration": 6121490021,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Group creation",
  "description": "",
  "id": "groups;group-creation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "a set of groups",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I create a new group with name xxx, header yyy and footer zzz",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the new set of groups is equal to the old set with the added group",
  "keyword": "Then "
});
formatter.match({
  "location": "GroupStepDefinitions.loadGroups()"
});
formatter.result({
  "duration": 415044991,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "xxx",
      "offset": 31
    },
    {
      "val": "yyy",
      "offset": 43
    },
    {
      "val": "zzz",
      "offset": 58
    }
  ],
  "location": "GroupStepDefinitions.createGroup(String,String,String)"
});
formatter.result({
  "duration": 950637723,
  "status": "passed"
});
formatter.match({
  "location": "GroupStepDefinitions.verifyGroupCreated()"
});
formatter.result({
  "duration": 64579239,
  "status": "passed"
});
formatter.after({
  "duration": 1043658241,
  "status": "passed"
});
});