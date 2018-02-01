package edu.hm.hafner.analysis.parser;

import java.util.Iterator;

import edu.hm.hafner.analysis.AbstractIssueParserTest;
import edu.hm.hafner.analysis.Issue;
import edu.hm.hafner.analysis.Issues;
import edu.hm.hafner.analysis.Priority;
import static edu.hm.hafner.analysis.assertj.Assertions.*;
import edu.hm.hafner.analysis.assertj.SoftAssertions;

/**
 * Tests the class {@link ResharperInspectCodeParser}.
 */
class ResharperInspectCodeParserTest extends AbstractIssueParserTest {
    private static final String ISSUES_FILE = "ResharperInspectCode.xml";

    /**
     * Creates a new instance of {@link ResharperInspectCodeParserTest}.
     */
    ResharperInspectCodeParserTest() {
        super(ISSUES_FILE);
    }

    @Override
    protected void assertThatIssuesArePresent(final Issues<Issue> issues, final SoftAssertions softly) {
        assertThat(issues).hasSize(3);

        Iterator<Issue> iterator = issues.iterator();

        softly.assertThat(iterator.next())
                .hasLineStart(16)
                .hasLineEnd(16)
                .hasMessage("Cannot resolve symbol 'GetError'")
                .hasFileName("ResharperDemo/Program.cs")
                .hasCategory("CSharpErrors")
                .hasPriority(Priority.HIGH);

        softly.assertThat(iterator.next())
                .hasLineStart(23)
                .hasLineEnd(23)
                .hasMessage("Expression is always true")
                .hasFileName("ResharperDemo/Program.cs")
                .hasCategory("ConditionIsAlwaysTrueOrFalse")
                .hasPriority(Priority.NORMAL);

        softly.assertThat(iterator.next())
                .hasLineStart(41)
                .hasLineEnd(41)
                .hasMessage("Convert to auto-property")
                .hasFileName("ResharperDemo/Program.cs")
                .hasCategory("ConvertToAutoProperty")
                .hasPriority(Priority.LOW);
    }

    @Override
    protected ResharperInspectCodeParser createParser() {
        return new ResharperInspectCodeParser();
    }
}

