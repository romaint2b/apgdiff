/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * Contains parsed command line arguments.
 *
 * @author fordfrog
 */
public class PgDiffArguments {

    /**
     * Input file charset name.
     */
    private String inCharsetName = "UTF-8";
    /**
     * Path to the new dump file.
     */
    private String newDumpFile;
    /**
     * Path to the original dump file.
     */
    private String oldDumpFile;
    /**
     * Output file charset name.
     */
    private String outCharsetName = "UTF-8";
    /**
     * Whether DEFAULT ... should be added in case new column has NOT NULL
     * constraint. The default value is dropped later.
     */
    private boolean addDefaults;
    /**
     * Whether to enclose all statements in transaction.
     */
    private boolean addTransaction;
    /**
     * Whether to ignore whitespace while comparing content of functions.
     */
    private boolean ignoreFunctionWhitespace;
    /**
     * Whether to ignore START WITH on SEQUENCEs.
     */
    private boolean ignoreStartWith;
    /**
     * Whether to display apgdiff version.
     */
    private boolean version;
    /**
     * Whether to output information about ignored statements.
     */
    private boolean outputIgnoredStatements;
    /**
     * Whether to list supported charsets.
     */
    private boolean listCharsets;
    /**
     * Whether Slony triggers should be ignored.
     */
    private boolean ignoreSlonyTriggers;
    /**
     * Whether Schema creation should be ignored.
     */
    private boolean ignoreSchemaCreation;
    /**
     * Drop If Exists and Create If Exists where possible
     */
    private boolean useIfExists;

   
    /**
     * Drop Columns
     */
    private boolean dropColumns=true;
    /**
     * Drop Tables
     */
    private boolean dropTables=true;
    /**
     * Drop Constraints
     */
    private boolean dropConstraints=true;
    /**
     * Drop Views
     */
    private boolean dropViews=true;
    /**
     * Drop Types
     */
    private boolean dropTypes=true;
    /**
     * Drop Triggers
     */
    private boolean dropTriggers=true;
    /**
     * Drop Rules
     */
    private boolean dropRules=true;
    /**
     * Drop Functions
     */
    private boolean dropFunctions=true;
    /**
     * Drop Procedure
     */
    private boolean dropProcedures=true;
    /**
     * Drop Indexes
     */
    private boolean dropIndexes=true;
    /**
     * Drop Clusters
     */
    private boolean dropClusters=true;
    /**
     * Drop Sequences
     */
    private boolean dropSequences=true;
    /**
     * Drop Policies
     */
    private boolean dropPolicies=true;

    //Arguments
    private static final String ARG_DISABLE_DROP_ALL="--disableDrop";
    private static final String ARG_DISABLE_DROP_CLUSTER="--disableDrop-clusters";
    private static final String ARG_DISABLE_DROP_COLUMNS="--disableDrop-columns";
    private static final String ARG_DISABLE_DROP_TABLES="--disableDrop-tables";
    private static final String ARG_DISABLE_DROP_CONSTRAINTS="--disableDrop-constraints";
    private static final String ARG_DISABLE_DROP_FUNCTIONS="--disableDrop-functions";
    private static final String ARG_DISABLE_DROP_INDEXES="--disableDrop-indexes";
    private static final String ARG_DISABLE_DROP_POLICIES="--disableDrop-policies";
    private static final String ARG_DISABLE_DROP_PROCEDURES="--disableDrop-procedures";
    private static final String ARG_DISABLE_DROP_RULES="--disableDrop-rules";
    private static final String ARG_DISABLE_DROP_SEQUENCES="--disableDrop-sequences";
    private static final String ARG_DISABLE_DROP_TRIGGERS="--disableDrop-triggers";
    private static final String ARG_DISABLE_DROP_TYPES="--disableDrop-types";
    private static final String ARG_DISABLE_DROP_VIEWS="--disableDrop-views";    
    
    /**
     * Setter for {@link #addDefaults}.
     *
     * @param addDefaults {@link #addDefaults}
     */
    public void setAddDefaults(final boolean addDefaults) {
        this.addDefaults = addDefaults;
    }

    /**
     * Getter for {@link #addDefaults}.
     *
     * @return {@link #addDefaults}
     */
    public boolean isAddDefaults() {
        return addDefaults;
    }

    /**
     * Setter for {@link #addTransaction}.
     *
     * @param addTransaction {@link #addTransaction}
     */
    public void setAddTransaction(final boolean addTransaction) {
        this.addTransaction = addTransaction;
    }

    /**
     * Getter for {@link #addTransaction}.
     *
     * @return {@link #addTransaction}
     */
    public boolean isAddTransaction() {
        return addTransaction;
    }

    /**
     * Setter for {@link #ignoreFunctionWhitespace}.
     *
     * @param ignoreFunctionWhitespace {@link #ignoreFunctionWhitespace}
     */
    public void setIgnoreFunctionWhitespace(
            final boolean ignoreFunctionWhitespace) {
        this.ignoreFunctionWhitespace = ignoreFunctionWhitespace;
    }

    /**
     * Getter for {@link #ignoreFunctionWhitespace}.
     *
     * @return {@link #ignoreFunctionWhitespace}
     */
    public boolean isIgnoreFunctionWhitespace() {
        return ignoreFunctionWhitespace;
    }

    /**
     * Setter for {@link #ignoreStartWith}.
     *
     * @param ignoreStartWith {@link #ignoreStartWith}
     */
    public void setIgnoreStartWith(final boolean ignoreStartWith) {
        this.ignoreStartWith = ignoreStartWith;
    }

    /**
     * Getter for {@link #ignoreStartWith}.
     *
     * @return {@link #ignoreStartWith}
     */
    public boolean isIgnoreStartWith() {
        return ignoreStartWith;
    }

    /**
     * Setter for {@link #newDumpFile}.
     *
     * @param newDumpFile {@link #newDumpFile}
     */
    public void setNewDumpFile(final String newDumpFile) {
        this.newDumpFile = newDumpFile;
    }

    /**
     * Getter for {@link #newDumpFile}.
     *
     * @return {@link #newDumpFile}
     */
    public String getNewDumpFile() {
        return newDumpFile;
    }

    /**
     * Setter for {@link #oldDumpFile}.
     *
     * @param oldDumpFile {@link #oldDumpFile}
     */
    public void setOldDumpFile(final String oldDumpFile) {
        this.oldDumpFile = oldDumpFile;
    }

    /**
     * Getter for {@link #oldDumpFile}.
     *
     * @return {@link #oldDumpFile}
     */
    public String getOldDumpFile() {
        return oldDumpFile;
    }

    /**
     * Getter for {@link #outputIgnoredStatements}.
     *
     * @return {@link #outputIgnoredStatements}
     */
    public boolean isOutputIgnoredStatements() {
        return outputIgnoredStatements;
    }

    /**
     * Setter for {@link #outputIgnoredStatements}.
     *
     * @param outputIgnoredStatements {@link #outputIgnoredStatements}
     */
    public void setOutputIgnoredStatements(
            final boolean outputIgnoredStatements) {
        this.outputIgnoredStatements = outputIgnoredStatements;
    }

    /**
     * Setter for {@link #version}.
     *
     * @param version {@link #version}
     */
    public void setVersion(final boolean version) {
        this.version = version;
    }

    /**
     * Getter for {@link #version}.
     *
     * @return {@link #version}
     */
    public boolean isVersion() {
        return version;
    }

    /**
     * Parses command line arguments or outputs instructions.
     *
     * @param writer writer to be used for info output
     * @param args   array of arguments
     *
     * @return true if arguments were parsed and execution can continue,
     *         otherwise false
     */
    @SuppressWarnings("AssignmentToForLoopParameter")
    public boolean parse(final PrintWriter writer, final String[] args) {
        boolean success = true;
        final int argsLength;

        if (args.length >= 2) {
            argsLength = args.length - 2;
        } else {
            argsLength = args.length;
        }

        for (int i = 0; i < argsLength; i++) {
            if ("--add-defaults".equals(args[i])) {
                setAddDefaults(true);
            } else if ("--add-transaction".equals(args[i])) {
                setAddTransaction(true);
            } else if ("--ignore-function-whitespace".equals(args[i])) {
                setIgnoreFunctionWhitespace(true);
            } else if ("--ignore-slony-triggers".equals(args[i])) {
                setIgnoreSlonyTriggers(true);
            } else if ("--ignore-start-with".equals(args[i])) {
                setIgnoreStartWith(true);
            } else if ("--ignore-schema-creation".equals(args[i])) {
                setIgnoreSchemaCreation(true);
            } else if ("--in-charset-name".equals(args[i])) {
                setInCharsetName(args[i + 1]);
                i++;
            } else if ("--list-charsets".equals(args[i])) {
                setListCharsets(true);
            } else if ("--out-charset-name".equals(args[i])) {
                setOutCharsetName(args[i + 1]);
                i++;
            } else if ("--output-ignored-statements".equals(args[i])) {
                setOutputIgnoredStatements(true);
            } else if ("--version".equals(args[i])) {
                setVersion(true);
            } else if ("--drop-if-exists".equals(args[i])) {
               PgDiffUtils.setUseExists(true);
            } else if (ARG_DISABLE_DROP_ALL.equals(args[i])) {
               disableDrop();
            } else if (ARG_DISABLE_DROP_CLUSTER.equals(args[i])) {
               setDropClusters(false);
            } else if (ARG_DISABLE_DROP_COLUMNS.equals(args[i])) {
               setDropColumns(false);
            } else if (ARG_DISABLE_DROP_CONSTRAINTS.equals(args[i])) {
               setDropConstraints(false);
            } else if (ARG_DISABLE_DROP_FUNCTIONS.equals(args[i])) {
               setDropFunctions(false);
            } else if (ARG_DISABLE_DROP_INDEXES.equals(args[i])) {
               setDropIndexes(false);
            } else if (ARG_DISABLE_DROP_POLICIES.equals(args[i])) {
               setDropPolicies(false);
            } else if (ARG_DISABLE_DROP_PROCEDURES.equals(args[i])) {
               setDropProcedures(false);
            } else if (ARG_DISABLE_DROP_RULES.equals(args[i])) {
               setDropRules(false);
            } else if (ARG_DISABLE_DROP_SEQUENCES.equals(args[i])) {
               setDropSequences(false);
            } 
            else if (ARG_DISABLE_DROP_TABLES.equals(args[i])) {
               setDropTables(false);
            } 
            else if (ARG_DISABLE_DROP_TRIGGERS.equals(args[i])) {
               setDropTriggers(success);
            } 
            else if (ARG_DISABLE_DROP_TYPES.equals(args[i])) {
               setDropTypes(false);
            } 
            else if (ARG_DISABLE_DROP_VIEWS.equals(args[i])) {
               setDropViews(false);
            } else {
                writer.print(Resources.getString("ErrorUnknownOption"));
                writer.print(": ");
                writer.println(args[i]);
                success = false;

                break;
            }
        }

        if (args.length == 1 && isVersion()) {
            printVersion(writer);
            success = false;
        } else if (args.length == 1 && isListCharsets()) {
            listCharsets(writer);
            success = false;
        } else if (args.length < 2) {
            printUsage(writer);
            success = false;
        } else if (success) {
            setOldDumpFile(args[args.length - 2]);
            setNewDumpFile(args[args.length - 1]);
        }

        return success;
    }
    
    private void disableDrop()
    {
       setDropClusters(false);
       setDropColumns(false);
       setDropConstraints(false);
       setDropFunctions(false);
       setDropIndexes(false);
       setDropPolicies(false);
       setDropProcedures(false);
       setDropRules(false);
       setDropSequences(false);
       setDropTables(false);
       setDropTriggers(false);
       setDropTypes(false);
       setDropViews(false);
    }

    /**
     * Prints program usage.
     *
     * @param writer writer to print the usage to
     */
    private void printUsage(final PrintWriter writer) {
        writer.println(
                Resources.getString("UsageHelp").replace("${tab}", "\t"));
    }

    /**
     * Prints program version.
     *
     * @param writer writer to print the usage to
     */
    private void printVersion(final PrintWriter writer) {
        writer.print(Resources.getString("Version"));
        writer.print(": ");
        writer.println(Resources.getString("VersionNumber"));
    }

    /**
     * Getter for {@link #inCharsetName}.
     *
     * @return {@link #inCharsetName}
     */
    public String getInCharsetName() {
        return inCharsetName;
    }

    /**
     * Setter for {@link #inCharsetName}.
     *
     * @param inCharsetName {@link #inCharsetName}
     */
    public void setInCharsetName(final String inCharsetName) {
        this.inCharsetName = inCharsetName;
    }

    /**
     * Getter for {@link #outCharsetName}.
     *
     * @return {@link #outCharsetName}
     */
    public String getOutCharsetName() {
        return outCharsetName;
    }

    /**
     * Setter for {@link #outCharsetName}.
     *
     * @param outCharsetName {@link #outCharsetName}
     */
    public void setOutCharsetName(final String outCharsetName) {
        this.outCharsetName = outCharsetName;
    }

    /**
     * Getter for {@link #listCharsets}.
     *
     * @return {@link #listCharsets}
     */
    public boolean isListCharsets() {
        return listCharsets;
    }

    /**
     * Setter for {@link #listCharsets}.
     *
     * @param listCharsets {@link #listCharsets}
     */
    public void setListCharsets(final boolean listCharsets) {
        this.listCharsets = listCharsets;
    }

    /**
     * Lists supported charsets.
     *
     * @param writer writer
     */
    private void listCharsets(final PrintWriter writer) {
        final SortedMap<String, Charset> charsets = Charset.availableCharsets();

        for (final String name : charsets.keySet()) {
            writer.println(name);
        }
    }

    /**
     * Getter for {@link #ignoreSlonyTriggers}.
     *
     * @return {@link #ignoreSlonyTriggers}
     */
    public boolean isIgnoreSlonyTriggers() {
        return ignoreSlonyTriggers;
    }

    /**
     * Setter for {@link #ignoreSlonyTriggers}.
     *
     * @param ignoreSlonyTriggers {@link #ignoreSlonyTriggers}
     */
    public void setIgnoreSlonyTriggers(final boolean ignoreSlonyTriggers) {
        this.ignoreSlonyTriggers = ignoreSlonyTriggers;
    }

    /**
     * Getter for {@link #ignoreSchemaCreation}.
     *
     * @return {@link #ignoreSchemaCreation}
     */
    public boolean isIgnoreSchemaCreation() {
        return this.ignoreSchemaCreation;
    }

    /**
     * Setter for {@link #ignoreSchemaCreation}.
     *
     * @param ignoreSchemaCreation {@link #ignoreSchemaCreation}
     */
    public void setIgnoreSchemaCreation(final boolean ignoreSchemaCreation) {
        this.ignoreSchemaCreation = ignoreSchemaCreation;
    }

   /**
    * Getter for {@link #dropColumns}.
    *
    * @return {@link #dropColumns}
    */
   public boolean isDropColumns()
   {
      return dropColumns;
   }

   /**
    * Getter for {@link #dropTables}.
    *
    * @return {@link #dropTables}
    */
   public boolean isDropTables()
   {
      return dropTables;
   }

   /**
    * Getter for {@link #dropConstraints}.
    *
    * @return {@link #dropConstraints}
    */
   public boolean isDropConstraints()
   {
      return dropConstraints;
   }

   /**
    * Getter for {@link #dropViews}.
    *
    * @return {@link #dropViews}
    */
   public boolean isDropViews()
   {
      return dropViews;
   }

   /**
    * Getter for {@link #dropTypes}.
    *
    * @return {@link #dropTypes}
    */
   public boolean isDropTypes()
   {
      return dropTypes;
   }

   /**
    * Getter for {@link #dropTriggers}.
    *
    * @return {@link #dropTriggers}
    */
   public boolean isDropTriggers()
   {
      return dropTriggers;
   }

   /**
    * Getter for {@link #dropRules}.
    *
    * @return {@link #dropRules}
    */
   public boolean isDropRules()
   {
      return dropRules;
   }

   /**
    * Getter for {@link #dropFunctions}.
    *
    * @return {@link #dropFunctions}
    */
   public boolean isDropFunctions()
   {
      return dropFunctions;
   }

   /**
    * Getter for {@link #dropProcedures}.
    *
    * @return {@link #dropProcedures}
    */
   public boolean isDropProcedures()
   {
      return dropProcedures;
   }

   /**
    * Getter for {@link #dropIndexes}.
    *
    * @return {@link #dropIndexes}
    */
   public boolean isDropIndexes()
   {
      return dropIndexes;
   }

   /**
    * Getter for {@link #dropClusters}.
    *
    * @return {@link #dropClusters}
    */
   public boolean isDropClusters()
   {
      return dropClusters;
   }

   /**
    * Getter for {@link #dropSequences}.
    *
    * @return {@link #dropSequences}
    */
   public boolean isDropSequences()
   {
      return dropSequences;
   }

   /**
    * Getter for {@link #dropPolicies}.
    *
    * @return {@link #dropPolicies}
    */
   public boolean isDropPolicies()
   {
      return dropPolicies;
   }

   /**
    * Setter for {@link #dropColumns}.
    *
    * @param dropColumns {@link #dropColumns}
    */
   
   public void setDropColumns(boolean dropColumns)
   {
      this.dropColumns = dropColumns;
   }

   /**
    * Setter for {@link #dropTables}.
    *
    * @param dropTables {@link #dropTables}
    */
   
   public void setDropTables(boolean dropTables)
   {
      this.dropTables = dropTables;
   }

   /**
    * Setter for {@link #dropConstraints}.
    *
    * @param dropConstraints {@link #dropConstraints}
    */
   
   public void setDropConstraints(boolean dropConstraints)
   {
      this.dropConstraints = dropConstraints;
   }

   /**
    * Setter for {@link #dropViews}.
    *
    * @param dropViews {@link #dropViews}
    */
   
   public void setDropViews(boolean dropViews)
   {
      this.dropViews = dropViews;
   }

   /**
    * Setter for {@link #dropTypes}.
    *
    * @param dropTypes {@link #dropTypes}
    */
   
   public void setDropTypes(boolean dropTypes)
   {
      this.dropTypes = dropTypes;
   }

   /**
    * Setter for {@link #dropTriggers}.
    *
    * @param dropTriggers {@link #dropTriggers}
    */
   
   public void setDropTriggers(boolean dropTriggers)
   {
      this.dropTriggers = dropTriggers;
   }

   /**
    * Setter for {@link #dropRules}.
    *
    * @param dropRules {@link #dropRules}
    */
   
   public void setDropRules(boolean dropRules)
   {
      this.dropRules = dropRules;
   }

   /**
    * Setter for {@link #dropFunctions}.
    *
    * @param dropFunctions {@link #dropFunctions}
    */
   
   public void setDropFunctions(boolean dropFunctions)
   {
      this.dropFunctions = dropFunctions;
   }

   /**
    * Setter for {@link #dropProcedures}.
    *
    * @param dropProcedures {@link #dropProcedures}
    */
   
   public void setDropProcedures(boolean dropProcedures)
   {
      this.dropProcedures = dropProcedures;
   }

   /**
    * Setter for {@link #dropIndexes}.
    *
    * @param dropIndexes {@link #dropIndexes}
    */
   
   public void setDropIndexes(boolean dropIndexes)
   {
      this.dropIndexes = dropIndexes;
   }

   /**
    * Setter for {@link #dropClusters}.
    *
    * @param dropClusters {@link #dropClusters}
    */
   
   public void setDropClusters(boolean dropClusters)
   {
      this.dropClusters = dropClusters;
   }

   /**
    * Setter for {@link #dropSequences}.
    *
    * @param dropSequences {@link #dropSequences}
    */
   
   public void setDropSequences(boolean dropSequences)
   {
      this.dropSequences = dropSequences;
   }

   /**
    * Setter for {@link #dropPolicies}.
    *
    * @param dropPolicies {@link #dropPolicies}
    */
   
   public void setDropPolicies(boolean dropPolicies)
   {
      this.dropPolicies = dropPolicies;
   }
    
    
}
