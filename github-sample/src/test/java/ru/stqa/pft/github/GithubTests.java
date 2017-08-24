package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by gpodmorina on 24.08.2017.
 */
public class GithubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("2823604dd0d3b57822649957a59eda569ce31a6b");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("GalinaPo", "java_training")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
