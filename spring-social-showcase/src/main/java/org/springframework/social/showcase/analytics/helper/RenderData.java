package org.springframework.social.showcase.analytics.helper;

public class RenderData {

    protected String xml;
    protected String chartId = "basicChart";
    protected String URL = "Data/Data.xml";
    protected String jsonUrl = "Data/Data.json";
    protected String width = "600";
    protected String height = "300";
    //protected String swfFilename = ChartType.COLUMN3D.getFileName();
    protected String uniqueId = ""; 
    public RenderData() {
      xml = "<chart caption='Monthly Unit Sales' xAxisName='Month' yAxisName='Units' showValues='0' formatNumberScale='0' showBorder='1'>";
      xml += "<set label='Jan' value='462' />";
      xml += "<set label='Feb' value='857' />";
      xml += "<set label='Mar' value='671' />";
      xml += "<set label='Apr' value='494' />";
      xml += "<set label='May' value='761' />";
      xml += "<set label='Jun' value='960' />";
      xml += "<set label='Jul' value='629' />";
      xml += "<set label='Aug' value='622' />";
      xml += "<set label='Sep' value='376' />";
      xml += "<set label='Oct' value='494' />";
      xml += "<set label='Nov' value='761' />";
      xml += "<set label='Dec' value='960' />";
      xml += "</chart>";
    }

  //  getters and setters

}
