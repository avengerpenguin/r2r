// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g 2010-07-23 16:36:55

  package de.fuberlin.wiwiss.r2r.parser;
  
  import de.fuberlin.wiwiss.r2r.*;
  import java.util.List;
  import java.util.ArrayList;
  import java.util.Set;
  import java.util.HashSet;
  import java.util.Collections;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TransformationParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "MINUS", "MULT", "DIV", "VAR1", "VAR2", "FUNCTIONNAME", "INTEGER", "DECIMAL", "DOUBLE", "STRING_LITERAL1", "STRING_LITERAL2", "STRING_LITERAL_LONG1", "STRING_LITERAL_LONG2", "VARNAME", "EXPONENT", "ECHAR", "PN_CHARS_U", "WS", "PN_CHARS_BASE", "PN_CHARS", "PN_PREFIX", "PN_LOCAL", "'='", "'('", "')'", "'['", "'?'", "':'", "']'", "'>'", "'>='", "'<'", "'<='", "'!='", "','"
    };
    public static final int INTEGER=11;
    public static final int EXPONENT=19;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int PN_LOCAL=26;
    public static final int MINUS=5;
    public static final int MULT=6;
    public static final int EOF=-1;
    public static final int ECHAR=20;
    public static final int FUNCTIONNAME=10;
    public static final int VARNAME=18;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int WS=22;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int PN_CHARS_BASE=23;
    public static final int STRING_LITERAL_LONG2=17;
    public static final int T__35=35;
    public static final int DECIMAL=12;
    public static final int T__36=36;
    public static final int VAR1=8;
    public static final int T__37=37;
    public static final int STRING_LITERAL_LONG1=16;
    public static final int VAR2=9;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int PN_PREFIX=25;
    public static final int STRING_LITERAL2=15;
    public static final int STRING_LITERAL1=14;
    public static final int PN_CHARS=24;
    public static final int DOUBLE=13;
    public static final int PN_CHARS_U=21;
    public static final int PLUS=4;
    public static final int DIV=7;

    // delegates
    // delegators


        public TransformationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public TransformationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return TransformationParser.tokenNames; }
    public String getGrammarFileName() { return "/home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g"; }


      FunctionManager funcManager;
      FunctionMapper funcMapper=new FunctionMapper();
      Set<String> variables = new HashSet<String>();
      boolean targetVariableParsed = false;
      
      public void setFunctionManager(FunctionManager fm) {
        funcManager = fm;
      }
      
      public void setFunctionMapping(FunctionMapper fm) {
        funcMapper = fm;
      }
      
      public void recover(IntStream input, RecognitionException re) {
        String hdr = getErrorHeader(re);
        String msg = getErrorMessage(re, this.getTokenNames());
        
        throw new ParseException(hdr + " " + msg);
      }
      
      public void reportError(RecognitionException re) {
        String hdr = getErrorHeader(re);
        String msg = getErrorMessage(re, this.getTokenNames());
        
        throw new ParseException(hdr + " " + msg);
      }
      
      private FunctionExecution createFunctionExecution(String functionName, Argument... args) {
        List<Argument> arguments = new ArrayList<Argument>();
        for(Argument arg: args)
          arguments.add(arg);
        String uri = funcMapper.getFunctionUri(functionName);
        Function function = funcManager.getFunctionByUri(uri);
        if(function==null)
          throw new ParseException("Function Manager could not find/load Function <" + uri + ">");

        return new FunctionExecution(function, Collections.unmodifiableList(arguments));
      }


    public static class transform_return extends ParserRuleReturnScope {
        public String variable;
        public FunctionExecution funcExec;
        public Set<String> variableDependencies;
    };

    // $ANTLR start "transform"
    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:79:1: transform returns [String variable, FunctionExecution funcExec, Set<String> variableDependencies] : v= variable '=' expression EOF ;
    public final TransformationParser.transform_return transform() throws RecognitionException {
        TransformationParser.transform_return retval = new TransformationParser.transform_return();
        retval.start = input.LT(1);

        TransformationParser.variable_return v = null;

        Argument expression1 = null;


        try {
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:80:3: (v= variable '=' expression EOF )
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:80:5: v= variable '=' expression EOF
            {
            pushFollow(FOLLOW_variable_in_transform62);
            v=variable();

            state._fsp--;

            match(input,27,FOLLOW_27_in_transform64); 
            pushFollow(FOLLOW_expression_in_transform66);
            expression1=expression();

            state._fsp--;

            match(input,EOF,FOLLOW_EOF_in_transform68); 

                  String var = (v!=null?input.toString(v.start,v.stop):null);
                  retval.variable = var.substring(1);
                  Argument argument = expression1;
                  if(argument instanceof FunctionExecution)
                    retval.funcExec = (FunctionExecution) argument;
                  else {
                    retval.funcExec = createFunctionExecution("identityFunction", argument);
                  }
                  retval.variableDependencies = variables;
                

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "transform"


    // $ANTLR start "expression"
    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:95:1: expression returns [Argument value] : m= mult ( ( PLUS | MINUS ) m= mult )* ;
    public final Argument expression() throws RecognitionException {
        Argument value = null;

        Argument m = null;


        try {
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:96:3: (m= mult ( ( PLUS | MINUS ) m= mult )* )
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:96:5: m= mult ( ( PLUS | MINUS ) m= mult )*
            {
            pushFollow(FOLLOW_mult_in_expression94);
            m=mult();

            state._fsp--;

             value = m; String operation = null;
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:97:4: ( ( PLUS | MINUS ) m= mult )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=PLUS && LA2_0<=MINUS)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:97:5: ( PLUS | MINUS ) m= mult
            	    {
            	    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:97:5: ( PLUS | MINUS )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==PLUS) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==MINUS) ) {
            	        alt1=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:97:7: PLUS
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_expression104); 
            	            operation = "add"; 

            	            }
            	            break;
            	        case 2 :
            	            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:98:7: MINUS
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_expression114); 
            	            operation = "subtract"; 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_mult_in_expression126);
            	    m=mult();

            	    state._fsp--;

            	     
            	                      value = createFunctionExecution(operation, value, m);
            	                    

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "expression"


    // $ANTLR start "mult"
    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:105:1: mult returns [Argument value] : u= unary ( ( MULT | DIV ) u= unary )* ;
    public final Argument mult() throws RecognitionException {
        Argument value = null;

        Argument u = null;


        try {
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:106:3: (u= unary ( ( MULT | DIV ) u= unary )* )
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:106:5: u= unary ( ( MULT | DIV ) u= unary )*
            {
            pushFollow(FOLLOW_unary_in_mult159);
            u=unary();

            state._fsp--;

             value = u; String operation = null;
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:107:4: ( ( MULT | DIV ) u= unary )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=MULT && LA4_0<=DIV)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:107:5: ( MULT | DIV ) u= unary
            	    {
            	    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:107:5: ( MULT | DIV )
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==MULT) ) {
            	        alt3=1;
            	    }
            	    else if ( (LA3_0==DIV) ) {
            	        alt3=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:107:7: MULT
            	            {
            	            match(input,MULT,FOLLOW_MULT_in_mult169); 
            	             operation = "multiply"; 

            	            }
            	            break;
            	        case 2 :
            	            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:108:7: DIV
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_mult181); 
            	             operation = "divide"; 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unary_in_mult193);
            	    u=unary();

            	    state._fsp--;


            	                    value = createFunctionExecution(operation, value, u);
            	                  

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "mult"


    // $ANTLR start "unary"
    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:115:1: unary returns [Argument value] : ( ( MINUS | PLUS ) )* term ;
    public final Argument unary() throws RecognitionException {
        Argument value = null;

        Argument term2 = null;


        try {
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:116:3: ( ( ( MINUS | PLUS ) )* term )
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:116:5: ( ( MINUS | PLUS ) )* term
            {
            boolean negative = false;
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:117:3: ( ( MINUS | PLUS ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=PLUS && LA6_0<=MINUS)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:117:5: ( MINUS | PLUS )
            	    {
            	    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:117:5: ( MINUS | PLUS )
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==MINUS) ) {
            	        alt5=1;
            	    }
            	    else if ( (LA5_0==PLUS) ) {
            	        alt5=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:117:6: MINUS
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_unary228); 
            	             negative = !negative; 

            	            }
            	            break;
            	        case 2 :
            	            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:118:5: PLUS
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_unary236); 

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            pushFollow(FOLLOW_term_in_unary244);
            term2=term();

            state._fsp--;

             if(negative)
                          value = createFunctionExecution("negate", term2);
                        else
                          value = term2;
                      

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "unary"


    // $ANTLR start "term"
    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:126:1: term returns [Argument value] : ( function | variable | integer | decimal | doubleVal | string | '(' expression ')' | conditional );
    public final Argument term() throws RecognitionException {
        Argument value = null;

        FunctionExecution function3 = null;

        TransformationParser.variable_return variable4 = null;

        TransformationParser.integer_return integer5 = null;

        TransformationParser.decimal_return decimal6 = null;

        TransformationParser.doubleVal_return doubleVal7 = null;

        String string8 = null;

        Argument expression9 = null;

        Argument conditional10 = null;


        try {
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:127:3: ( function | variable | integer | decimal | doubleVal | string | '(' expression ')' | conditional )
            int alt7=8;
            switch ( input.LA(1) ) {
            case FUNCTIONNAME:
                {
                alt7=1;
                }
                break;
            case VAR1:
            case VAR2:
                {
                alt7=2;
                }
                break;
            case INTEGER:
                {
                alt7=3;
                }
                break;
            case DECIMAL:
                {
                alt7=4;
                }
                break;
            case DOUBLE:
                {
                alt7=5;
                }
                break;
            case STRING_LITERAL1:
            case STRING_LITERAL2:
            case STRING_LITERAL_LONG1:
            case STRING_LITERAL_LONG2:
                {
                alt7=6;
                }
                break;
            case 28:
                {
                alt7=7;
                }
                break;
            case 30:
                {
                alt7=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:127:5: function
                    {
                    pushFollow(FOLLOW_function_in_term265);
                    function3=function();

                    state._fsp--;

                     value = function3; 

                    }
                    break;
                case 2 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:128:5: variable
                    {
                    pushFollow(FOLLOW_variable_in_term273);
                    variable4=variable();

                    state._fsp--;

                     
                          String varName = (variable4!=null?input.toString(variable4.start,variable4.stop):null);
                          value = new VariableArgument(varName.substring(1));
                        

                    }
                    break;
                case 3 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:133:5: integer
                    {
                    pushFollow(FOLLOW_integer_in_term285);
                    integer5=integer();

                    state._fsp--;

                     value = new ConstantArgument(ConstantType.INTEGER, (integer5!=null?input.toString(integer5.start,integer5.stop):null)); 

                    }
                    break;
                case 4 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:134:5: decimal
                    {
                    pushFollow(FOLLOW_decimal_in_term293);
                    decimal6=decimal();

                    state._fsp--;

                     value = new ConstantArgument(ConstantType.DECIMAL, (decimal6!=null?input.toString(decimal6.start,decimal6.stop):null)); 

                    }
                    break;
                case 5 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:135:5: doubleVal
                    {
                    pushFollow(FOLLOW_doubleVal_in_term301);
                    doubleVal7=doubleVal();

                    state._fsp--;

                     value = new ConstantArgument(ConstantType.DOUBLE, (doubleVal7!=null?input.toString(doubleVal7.start,doubleVal7.stop):null)); 

                    }
                    break;
                case 6 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:136:5: string
                    {
                    pushFollow(FOLLOW_string_in_term309);
                    string8=string();

                    state._fsp--;


                          value = new ConstantArgument(ConstantType.STRING, string8);
                        

                    }
                    break;
                case 7 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:140:5: '(' expression ')'
                    {
                    match(input,28,FOLLOW_28_in_term321); 
                    pushFollow(FOLLOW_expression_in_term323);
                    expression9=expression();

                    state._fsp--;

                    match(input,29,FOLLOW_29_in_term325); 
                     value = expression9; 

                    }
                    break;
                case 8 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:141:5: conditional
                    {
                    pushFollow(FOLLOW_conditional_in_term333);
                    conditional10=conditional();

                    state._fsp--;

                     value = conditional10; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "term"


    // $ANTLR start "conditional"
    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:144:1: conditional returns [Argument value] : '[' leftEx= expression comp= comparisonOp rightEx= expression '?' trueEx= expression ':' falseEx= expression ']' ;
    public final Argument conditional() throws RecognitionException {
        Argument value = null;

        Argument leftEx = null;

        TransformationParser.comparisonOp_return comp = null;

        Argument rightEx = null;

        Argument trueEx = null;

        Argument falseEx = null;


        try {
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:145:3: ( '[' leftEx= expression comp= comparisonOp rightEx= expression '?' trueEx= expression ':' falseEx= expression ']' )
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:145:6: '[' leftEx= expression comp= comparisonOp rightEx= expression '?' trueEx= expression ':' falseEx= expression ']'
            {
            match(input,30,FOLLOW_30_in_conditional355); 
            pushFollow(FOLLOW_expression_in_conditional359);
            leftEx=expression();

            state._fsp--;

            pushFollow(FOLLOW_comparisonOp_in_conditional363);
            comp=comparisonOp();

            state._fsp--;

            pushFollow(FOLLOW_expression_in_conditional367);
            rightEx=expression();

            state._fsp--;

            match(input,31,FOLLOW_31_in_conditional369); 
            pushFollow(FOLLOW_expression_in_conditional373);
            trueEx=expression();

            state._fsp--;

            match(input,32,FOLLOW_32_in_conditional375); 
            pushFollow(FOLLOW_expression_in_conditional379);
            falseEx=expression();

            state._fsp--;

            match(input,33,FOLLOW_33_in_conditional381); 

              // Create the comparison argument
                Argument compOpArg = new ConstantArgument(ConstantType.STRING, (comp!=null?input.toString(comp.start,comp.stop):null));
                
              // First the compare function to calculate the boolean
                FunctionExecution comparisonFunction = createFunctionExecution("compare", compOpArg, leftEx, rightEx);

              // Then the booleanPick function to pick either the left or right value
                value = createFunctionExecution("booleanPick", comparisonFunction, trueEx, falseEx);
              

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "conditional"

    public static class comparisonOp_return extends ParserRuleReturnScope {
        public Argument value;
    };

    // $ANTLR start "comparisonOp"
    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:158:1: comparisonOp returns [Argument value] : ( '>' | '>=' | '=' | '<' | '<=' | '!=' );
    public final TransformationParser.comparisonOp_return comparisonOp() throws RecognitionException {
        TransformationParser.comparisonOp_return retval = new TransformationParser.comparisonOp_return();
        retval.start = input.LT(1);

        try {
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:159:3: ( '>' | '>=' | '=' | '<' | '<=' | '!=' )
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:
            {
            if ( input.LA(1)==27||(input.LA(1)>=34 && input.LA(1)<=38) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparisonOp"

    public static class variable_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "variable"
    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:163:1: variable : (v= VAR1 | v= VAR2 );
    public final TransformationParser.variable_return variable() throws RecognitionException {
        TransformationParser.variable_return retval = new TransformationParser.variable_return();
        retval.start = input.LT(1);

        Token v=null;

        try {
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:164:3: (v= VAR1 | v= VAR2 )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==VAR1) ) {
                alt8=1;
            }
            else if ( (LA8_0==VAR2) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:164:5: v= VAR1
                    {
                    v=(Token)match(input,VAR1,FOLLOW_VAR1_in_variable445); 

                          if(targetVariableParsed) {
                            String varName = (v!=null?v.getText():null);
                            variables.add(varName.substring(1));
                          }
                          else
                            targetVariableParsed = true; 
                        

                    }
                    break;
                case 2 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:173:5: v= VAR2
                    {
                    v=(Token)match(input,VAR2,FOLLOW_VAR2_in_variable459); 

                          if(targetVariableParsed) {
                            String varName = (v!=null?v.getText():null);
                            variables.add(varName.substring(1));
                          }
                          else
                            targetVariableParsed = true; 
                        

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variable"


    // $ANTLR start "function"
    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:184:1: function returns [FunctionExecution funcExec] : FUNCTIONNAME '(' (a= expression ( ',' a= expression )* )? ')' ;
    public final FunctionExecution function() throws RecognitionException {
        FunctionExecution funcExec = null;

        Token FUNCTIONNAME11=null;
        Argument a = null;


        try {
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:185:3: ( FUNCTIONNAME '(' (a= expression ( ',' a= expression )* )? ')' )
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:185:5: FUNCTIONNAME '(' (a= expression ( ',' a= expression )* )? ')'
            {
            FUNCTIONNAME11=(Token)match(input,FUNCTIONNAME,FOLLOW_FUNCTIONNAME_in_function484); 
             
                  List<Argument> arguments = new ArrayList<Argument>();
                  String fname = (FUNCTIONNAME11!=null?FUNCTIONNAME11.getText():null);
                  String uri = funcMapper.getFunctionUri(fname);
                  Function function = funcManager.getFunctionByUri(uri);
                  if(function==null)
                    throw new ParseException("Function Manager could not find/load Function <" + uri + ">");
                
            match(input,28,FOLLOW_28_in_function496); 
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:195:8: (a= expression ( ',' a= expression )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=PLUS && LA10_0<=MINUS)||(LA10_0>=VAR1 && LA10_0<=STRING_LITERAL_LONG2)||LA10_0==28||LA10_0==30) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:195:9: a= expression ( ',' a= expression )*
                    {
                    pushFollow(FOLLOW_expression_in_function509);
                    a=expression();

                    state._fsp--;

                     arguments.add(a); 
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:196:11: ( ',' a= expression )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==39) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:196:12: ',' a= expression
                    	    {
                    	    match(input,39,FOLLOW_39_in_function524); 
                    	    pushFollow(FOLLOW_expression_in_function528);
                    	    a=expression();

                    	    state._fsp--;

                    	     arguments.add(a);

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,29,FOLLOW_29_in_function548); 
             funcExec = new FunctionExecution(function, Collections.unmodifiableList(arguments));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return funcExec;
    }
    // $ANTLR end "function"

    public static class integer_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "integer"
    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:213:1: integer : INTEGER ;
    public final TransformationParser.integer_return integer() throws RecognitionException {
        TransformationParser.integer_return retval = new TransformationParser.integer_return();
        retval.start = input.LT(1);

        try {
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:214:3: ( INTEGER )
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:214:5: INTEGER
            {
            match(input,INTEGER,FOLLOW_INTEGER_in_integer577); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "integer"

    public static class decimal_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "decimal"
    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:217:1: decimal : DECIMAL ;
    public final TransformationParser.decimal_return decimal() throws RecognitionException {
        TransformationParser.decimal_return retval = new TransformationParser.decimal_return();
        retval.start = input.LT(1);

        try {
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:218:3: ( DECIMAL )
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:218:5: DECIMAL
            {
            match(input,DECIMAL,FOLLOW_DECIMAL_in_decimal591); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "decimal"

    public static class doubleVal_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "doubleVal"
    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:221:1: doubleVal : DOUBLE ;
    public final TransformationParser.doubleVal_return doubleVal() throws RecognitionException {
        TransformationParser.doubleVal_return retval = new TransformationParser.doubleVal_return();
        retval.start = input.LT(1);

        try {
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:222:3: ( DOUBLE )
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:222:5: DOUBLE
            {
            match(input,DOUBLE,FOLLOW_DOUBLE_in_doubleVal606); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "doubleVal"


    // $ANTLR start "string"
    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:225:2: string returns [String value] : (s= STRING_LITERAL1 | s= STRING_LITERAL2 | s= STRING_LITERAL_LONG1 | s= STRING_LITERAL_LONG2 );
    public final String string() throws RecognitionException {
        String value = null;

        Token s=null;

        try {
            // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:226:4: (s= STRING_LITERAL1 | s= STRING_LITERAL2 | s= STRING_LITERAL_LONG1 | s= STRING_LITERAL_LONG2 )
            int alt11=4;
            switch ( input.LA(1) ) {
            case STRING_LITERAL1:
                {
                alt11=1;
                }
                break;
            case STRING_LITERAL2:
                {
                alt11=2;
                }
                break;
            case STRING_LITERAL_LONG1:
                {
                alt11=3;
                }
                break;
            case STRING_LITERAL_LONG2:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:226:6: s= STRING_LITERAL1
                    {
                    s=(Token)match(input,STRING_LITERAL1,FOLLOW_STRING_LITERAL1_in_string627); 
                     String temp = (s!=null?s.getText():null); value = temp.substring(1, temp.length() - 1); 

                    }
                    break;
                case 2 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:227:6: s= STRING_LITERAL2
                    {
                    s=(Token)match(input,STRING_LITERAL2,FOLLOW_STRING_LITERAL2_in_string638); 
                     String temp = (s!=null?s.getText():null); value = temp.substring(1, temp.length() - 1); 

                    }
                    break;
                case 3 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:228:6: s= STRING_LITERAL_LONG1
                    {
                    s=(Token)match(input,STRING_LITERAL_LONG1,FOLLOW_STRING_LITERAL_LONG1_in_string649); 
                     String temp = (s!=null?s.getText():null); value = temp.substring(3, temp.length() - 3); 

                    }
                    break;
                case 4 :
                    // /home/andreas/code/mavenprojects/mapping/r2rApi/antlr-files/Transformation.g:229:6: s= STRING_LITERAL_LONG2
                    {
                    s=(Token)match(input,STRING_LITERAL_LONG2,FOLLOW_STRING_LITERAL_LONG2_in_string660); 
                     String temp = (s!=null?s.getText():null); value = temp.substring(3, temp.length() - 3); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "string"

    // Delegated rules


 

    public static final BitSet FOLLOW_variable_in_transform62 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_transform64 = new BitSet(new long[]{0x000000005003FF30L});
    public static final BitSet FOLLOW_expression_in_transform66 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_transform68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mult_in_expression94 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_PLUS_in_expression104 = new BitSet(new long[]{0x000000005003FF30L});
    public static final BitSet FOLLOW_MINUS_in_expression114 = new BitSet(new long[]{0x000000005003FF30L});
    public static final BitSet FOLLOW_mult_in_expression126 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_unary_in_mult159 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_MULT_in_mult169 = new BitSet(new long[]{0x000000005003FF30L});
    public static final BitSet FOLLOW_DIV_in_mult181 = new BitSet(new long[]{0x000000005003FF30L});
    public static final BitSet FOLLOW_unary_in_mult193 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_MINUS_in_unary228 = new BitSet(new long[]{0x000000005003FF30L});
    public static final BitSet FOLLOW_PLUS_in_unary236 = new BitSet(new long[]{0x000000005003FF30L});
    public static final BitSet FOLLOW_term_in_unary244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_term265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_term273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_in_term285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decimal_in_term293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doubleVal_in_term301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_in_term309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_term321 = new BitSet(new long[]{0x000000005003FF30L});
    public static final BitSet FOLLOW_expression_in_term323 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_term325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_in_term333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_conditional355 = new BitSet(new long[]{0x000000005003FF30L});
    public static final BitSet FOLLOW_expression_in_conditional359 = new BitSet(new long[]{0x0000007C08000000L});
    public static final BitSet FOLLOW_comparisonOp_in_conditional363 = new BitSet(new long[]{0x000000005003FF30L});
    public static final BitSet FOLLOW_expression_in_conditional367 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_conditional369 = new BitSet(new long[]{0x000000005003FF30L});
    public static final BitSet FOLLOW_expression_in_conditional373 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_conditional375 = new BitSet(new long[]{0x000000005003FF30L});
    public static final BitSet FOLLOW_expression_in_conditional379 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_conditional381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_comparisonOp0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR1_in_variable445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR2_in_variable459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTIONNAME_in_function484 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_function496 = new BitSet(new long[]{0x000000007003FF30L});
    public static final BitSet FOLLOW_expression_in_function509 = new BitSet(new long[]{0x0000008020000000L});
    public static final BitSet FOLLOW_39_in_function524 = new BitSet(new long[]{0x000000005003FF30L});
    public static final BitSet FOLLOW_expression_in_function528 = new BitSet(new long[]{0x0000008020000000L});
    public static final BitSet FOLLOW_29_in_function548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_integer577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_in_decimal591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_doubleVal606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL1_in_string627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL2_in_string638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_LONG1_in_string649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_LONG2_in_string660 = new BitSet(new long[]{0x0000000000000002L});

}