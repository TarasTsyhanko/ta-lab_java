<?xml version="1.0" encoding="UTF-8"?>
<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="utf-8"/>
            </head>
            <body>
                <h1>My GUNS collection:</h1>
                <table style="width:100%">
                    <tr>
                        <th>select</th>
                        <th>handy</th>
                        <th>origin</th>
                        <th>material</th>
                        <th>carry</th>
                        <th>sightingRange</th>
                        <th>optics</th>
                    </tr>
                    <xsl:for-each select="//Guns">
                        <xsl:sort select="origin"/>
                        <tr>
                            <td><xsl:value-of select="model"/></td>
                            <td><xsl:value-of select="handy"/></td>
                            <td><xsl:value-of select="origin"/></td>
                            <td><xsl:value-of select="material"/></td>
                            <td><xsl:value-of select="//ttc/carry"/></td>
                            <td><xsl:value-of select="//ttc/sightingRange"/></td>
                            <td><xsl:value-of select="//ttc/optics"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:transform>