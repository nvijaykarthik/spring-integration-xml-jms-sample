<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">



	<xsl:template match="@* | node()">
		<xsl:copy>
			<xsl:apply-templates select="@* | node()" />
		</xsl:copy>
	</xsl:template>



	<xsl:template match="orderItem[2]">
		<xsl:copy-of select="." />
	<xsl:text>&#x0A;</xsl:text>
		<orderItem>
		<xsl:text>&#x0A;</xsl:text>
			<isbn>78956425874</isbn>
			<xsl:text>&#x0A;</xsl:text>
			<quantity>15</quantity>
			<xsl:text>&#x0A;</xsl:text> 
		</orderItem>

	</xsl:template>


</xsl:stylesheet>