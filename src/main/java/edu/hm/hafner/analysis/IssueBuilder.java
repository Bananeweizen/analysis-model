package edu.hm.hafner.analysis;

import edu.umd.cs.findbugs.annotations.CheckForNull;

/**
 * Creates new {@link Issue issues} using the builder pattern. All properties that have not been set in the builder will
 * be set to their default value.
 * <p>Example:</p>
 * <p>
 * <blockquote><pre>
 * Issue issue = new IssueBuilder()
 *                      .setFileName("affected.file")
 *                      .setLineStart(0)
 *                      .setCategory("JavaDoc")
 *                      .setMessage("Missing JavaDoc")
 *                      .setPriority(Priority.LOW);
 * </pre></blockquote>
 * </p>
 *
 * @author Ullrich Hafner
 */
@SuppressWarnings({"InstanceVariableMayNotBeInitialized", "JavaDocMethod", "PMD.TooManyFields"})
public class IssueBuilder {
    private String fileName;
    private int lineStart = 0;
    private int lineEnd = 0;
    private int columnStart = 0;
    private int columnEnd = 0;
    @CheckForNull
    private LineRangeList lineRanges;
    @CheckForNull
    private String category;
    @CheckForNull
    private String type;
    @CheckForNull
    private Priority priority;
    @CheckForNull
    private String message;
    @CheckForNull
    private String description;
    @CheckForNull
    private String packageName;
    @CheckForNull
    private String moduleName;
    @CheckForNull
    private String origin;
    @CheckForNull
    private String reference;
    @CheckForNull
    private String fingerprint;

    public IssueBuilder setFingerprint(@CheckForNull final String fingerprint) {
        this.fingerprint = fingerprint;
        return this;
    }

    public IssueBuilder setFileName(@CheckForNull final String fileName) {
        this.fileName = fileName;
        return this;
    }

    public IssueBuilder setLineStart(@CheckForNull final int lineStart) {
        this.lineStart = lineStart;
        return this;
    }

    public IssueBuilder setLineEnd(@CheckForNull final int lineEnd) {
        this.lineEnd = lineEnd;
        return this;
    }

    public IssueBuilder setColumnStart(final int columnStart) {
        this.columnStart = columnStart;
        return this;
    }

    public IssueBuilder setColumnEnd(final int columnEnd) {
        this.columnEnd = columnEnd;
        return this;
    }

    public IssueBuilder setCategory(@CheckForNull final String category) {
        this.category = category;
        return this;
    }

    public IssueBuilder setType(@CheckForNull final String type) {
        this.type = type;
        return this;
    }

    public IssueBuilder setPackageName(@CheckForNull final String packageName) {
        this.packageName = packageName;
        return this;
    }

    public IssueBuilder setModuleName(@CheckForNull final String moduleName) {
        this.moduleName = moduleName;
        return this;
    }

    public IssueBuilder setOrigin(@CheckForNull final String origin) {
        this.origin = origin;
        return this;
    }

    public IssueBuilder setReference(@CheckForNull final String reference) {
        this.reference = reference;
        return this;
    }

    public IssueBuilder setPriority(@CheckForNull final Priority priority) {
        this.priority = priority;
        return this;
    }

    public IssueBuilder setMessage(@CheckForNull final String message) {
        this.message = message;
        return this;
    }

    public IssueBuilder setDescription(@CheckForNull final String description) {
        this.description = description;
        return this;
    }

    public IssueBuilder setLineRanges(final LineRangeList lineRanges) {
        this.lineRanges = new LineRangeList(lineRanges);
        return this;
    }

    /**
     * Initializes this builder with an exact copy of aal properties of the specified issue.
     *
     * @param copy
     *         the issue to copy the properties from
     *
     * @return the initialized builder
     */
    public IssueBuilder copy(final Issue copy) {
        fileName = copy.getFileName();
        lineStart = copy.getLineStart();
        lineEnd = copy.getLineEnd();
        columnStart = copy.getColumnStart();
        columnEnd = copy.getColumnEnd();
        category = copy.getCategory();
        type = copy.getType();
        priority = copy.getPriority();
        message = copy.getMessage();
        description = copy.getDescription();
        packageName = copy.getPackageName();
        moduleName = copy.getModuleName();
        origin = copy.getOrigin();
        reference = copy.getReference();
        fingerprint = copy.getFingerprint();
        lineRanges = copy.getLineRanges();
        return this;
    }

    /**
     * Creates a new {@link Issue} based on the specified properties.
     *
     * @return the created issue
     */
    public Issue build() {
        return new Issue(fileName, lineStart, lineEnd, columnStart, columnEnd, lineRanges, category, type,
                packageName, moduleName, priority, message, description, origin, reference, fingerprint);
    }
}