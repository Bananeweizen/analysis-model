package edu.hm.hafner.analysis.parser;

import edu.hm.hafner.analysis.AbstractIssueParserTest;
import edu.hm.hafner.analysis.Issue;
import edu.hm.hafner.analysis.Issues;
import edu.hm.hafner.analysis.Priority;
import edu.hm.hafner.analysis.assertj.SoftAssertions;

/**
 * Tests the class {@link AntJavacParser} for output log of a HPI compile.
 */
class HpiCompileParserTest extends AbstractIssueParserTest {
    HpiCompileParserTest() {
        super("hpi.txt");
    }

    @Override
    protected AntJavacParser createParser() {
        return new AntJavacParser();
    }

    @Override
    protected void assertThatIssuesArePresent(final Issues<Issue> issues, final SoftAssertions softly) {
        softly.assertThat(issues).hasSize(2);
        softly.assertThat(issues.get(0))
                .hasPriority(Priority.NORMAL)
                .hasCategory("Deprecation")
                .hasLineStart(46)
                .hasLineEnd(46)
                .hasMessage("newInstance(org.kohsuke.stapler.StaplerRequest) in hudson.model.Descriptor has been deprecated")
                .hasFileName("C:/Build/Results/jobs/ADT-Base/workspace/tasks/src/main/java/hudson/plugins/tasks/TasksDescriptor.java");
        softly.assertThat(issues.get(1))
                .hasPriority(Priority.NORMAL)
                .hasCategory("Deprecation")
                .hasLineStart(34)
                .hasLineEnd(34)
                .hasMessage("newInstance(org.kohsuke.stapler.StaplerRequest) in hudson.model.Descriptor has been deprecated")
                .hasFileName("C:/Build/Results/jobs/ADT-Base/workspace/tasks/src/main/java/hudson/plugins/tasks/TasksReporterDescriptor.java");
    }
}