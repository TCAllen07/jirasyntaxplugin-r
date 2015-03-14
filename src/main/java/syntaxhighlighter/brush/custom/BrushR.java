package syntaxhighlighter.brush.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import syntaxhighlighter.brush.Brush;
import syntaxhighlighter.brush.RegExpRule;

/**
 * R brush.
 * @author Trevor Allen <trevor.allen@valiance.io>
 */
public class BrushR extends Brush {

  public BrushR() {
    super();
    String keywords = "function if break next repeat else for return switch while in invisible";
    String constants = "TRUE FALSE NULL NA Inf NaN pi letters LETTERS month.abb month.name";

    List<RegExpRule> _regExpRuleList = new ArrayList<RegExpRule>();
    _regExpRuleList.add(new RegExpRule(RegExpRule.singleLinePerlComments, "comments"));
    _regExpRuleList.add(new RegExpRule(RegExpRule.doubleQuotedString, "string"));
    _regExpRuleList.add(new RegExpRule(RegExpRule.singleQuotedString, "string"));
    _regExpRuleList.add(new RegExpRule(getKeywords(keywords), Pattern.MULTILINE, "keyword"));
    _regExpRuleList.add(new RegExpRule(getKeywords(constants), Pattern.MULTILINE, "constants"));
    _regExpRuleList.add(new RegExpRule("\\+|\\-|\\*|\\/|\\%|\\%\\%|\\^", Pattern.MULTILINE, "keyword"));  // general arithmetic operators
    _regExpRuleList.add(new RegExpRule("==|!=|&lt;&gt;|&lt;|&gt;|&lt;=|&gt;=", Pattern.MULTILINE, "keyword"));  // comparison operators
    _regExpRuleList.add(new RegExpRule("=|(&lt;|\\<)\\-|\\-(&gt;|>)", Pattern.MULTILINE, "keyword"));  // assignment operators
    _regExpRuleList.add(new RegExpRule("(\\.\\.\\.|\\$|:|~)", "keyword"));  // additional R-specific operators, eg dataframe$varname
    _regExpRuleList.add(new RegExpRule("(!|&amp;{1,2}|[|]{1,2})", "keyword"));  // logical operators
    _regExpRuleList.add(new RegExpRule("(logical|numeric|character|complex|matrix|array|list|factor|data\\.frame)(?=\\s*\\()", "functions"));
    _regExpRuleList.add(new RegExpRule("\\b\\d+\\.?\\w*", "value"));
    // rollowing regex is for fancier ways to express numerics (0x6b, 2e10, etc.)
    _regExpRuleList.add(new RegExpRule("\\b((0(x|X)[0-9a-fA-F]*)|(([0-9]+\\.?[0-9]*)|(\\.[0-9]+))((e|E)(\\+|-)?[0-9]+)?)(L|l|UL|ul|u|U|F|f|ll|LL|ull|ULL)?\\b", "value"));
    setRegExpRuleList(_regExpRuleList);

    setCommonFileExtensionList(Arrays.asList("R", "Rhistory", "Rprofile"));
  }
}
