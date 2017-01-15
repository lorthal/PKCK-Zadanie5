<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fo="http://www.w3.org/1999/XSL/Format"
    version="1.0">

    <xsl:output method="xml" encoding="UTF-8"/>

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="Gry" page-height="297mm" page-width="210mm">
                    <fo:region-body margin="70px,50px"/>
                    <fo:region-before extent="5"/>
                    <fo:region-after extent="50"/>
                    <fo:region-start extent="5"/>
                    <fo:region-end extent="5"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="Gry">
                <fo:static-content flow-name="xsl-region-before">
                    <fo:block text-align="center" font-family="Arial" font-size="30px"
                        margin-top="5px">
                        <xsl:text>Gry</xsl:text>
                        <fo:block text-align="center" font-family="Arial" font-size="15px">
                            <xsl:apply-templates select="Gry/Podsumowanie/DataRaportu"
                                mode="display"/>
                        </fo:block>
                    </fo:block>
                </fo:static-content>
                <fo:static-content flow-name="xsl-region-after">
                    <fo:block text-align="right" font-family="Arial" font-size="30px"
                        margin-bottom="30px" margin-right="30px">
                        <fo:page-number/>
                    </fo:block>
                </fo:static-content>
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        <xsl:apply-templates/>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <xsl:template match="DataRaportu" mode="display">
        <xsl:value-of select="concat(substring(., 1, 10), '   ', substring(., 12, 5))"/>
    </xsl:template>

    <xsl:template match="DataRaportu"/>

    <xsl:template match="//Autorzy">
        <fo:block text-align="center" margin-left="100px" margin-right="100px" margin-bottom="200px" margin-top="100px">
            <fo:table border="solid black" border-width="3px">
                <fo:table-body>
                    <fo:table-row>
                        <fo:table-cell border-bottom="solid black">
                            <fo:block>
                                <xsl:text>Autorzy:</xsl:text>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                    <xsl:for-each select="Autor">
                        <fo:table-row>
                            <fo:table-cell>
                                <fo:block>
                                    <xsl:value-of select="concat(Indeks, ' ', Imię, ' ', Nazwisko)"
                                    />
                                </fo:block>
                            </fo:table-cell>
                        </fo:table-row>
                    </xsl:for-each>
                </fo:table-body>
            </fo:table>
        </fo:block>
    </xsl:template>

    <xsl:template match="//ListaFirm">
        <fo:block text-align="center" font-family="Arial" font-size="30px" margin-top="20px">
            <xsl:text>FIRMY</xsl:text>
        </fo:block>
        <fo:table border="solid black" border-width="3px">

            <fo:table-header>
                <fo:table-row>
                    <xsl:for-each select="Firma">
                        <fo:table-cell border="solid black">
                            <fo:block text-align="center">
                                <xsl:value-of
                                    select="concat(Nazwa, ' ', Lokalizacja, ' ', DataZałożenia)"/>
                            </fo:block>
                        </fo:table-cell>
                    </xsl:for-each>
                </fo:table-row>
            </fo:table-header>
            <fo:table-body>
                <fo:table-row>
                    <fo:table-cell border="solid black" text-align="center">
                        <fo:block>
                            <xsl:value-of select="Firma[1]/ListaGier/Gra[1]/Nazwa"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell border="solid black" text-align="center">
                        <fo:block>
                            <xsl:value-of select="Firma[2]/ListaGier/Gra[1]/Nazwa"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell border="solid black" text-align="center">
                        <fo:block>
                            <xsl:value-of select="Firma[3]/ListaGier/Gra[1]/Nazwa"/>
                        </fo:block>
                    </fo:table-cell>
                </fo:table-row>
                <fo:table-row>
                    <fo:table-cell border="solid black" text-align="center">
                        <fo:block>
                            <xsl:value-of select="Firma[1]/ListaGier/Gra[2]/Nazwa"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell border="solid black" text-align="center">
                        <fo:block>
                            <xsl:value-of select="Firma[2]/ListaGier/Gra[2]/Nazwa"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell border="solid black" text-align="center">
                        <fo:block>
                            <xsl:value-of select="Firma[3]/ListaGier/Gra[2]/Nazwa"/>
                        </fo:block>
                    </fo:table-cell>
                </fo:table-row>
                <fo:table-row>
                    <fo:table-cell border="solid black" text-align="center">
                        <fo:block>
                            <xsl:value-of select="Firma[1]/ListaGier/Gra[3]/Nazwa"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell border="solid black" text-align="center">
                        <fo:block>
                            <xsl:value-of select="Firma[2]/ListaGier/Gra[3]/Nazwa"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell border="solid black" text-align="center">
                        <fo:block>
                            <xsl:value-of select="Firma[3]/ListaGier/Gra[3]/Nazwa"/>
                        </fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-body>
        </fo:table>
    </xsl:template>

    <xsl:template match="Podsumowanie">
        <fo:block text-align="center" font-family="Arial" font-size="30px" margin-top="300px">
            <xsl:text>PODSUMOWANIE</xsl:text>
        </fo:block>
        <fo:block text-align="center" border="solid black" border-width="3px">
            <fo:table>
                <fo:table-body>
                    <fo:table-row>
                        <fo:table-cell>
                            <fo:block>
                                <xsl:value-of
                                    select="concat(substring(name(Statystyki/ActionRole-PlayingGame), 1, 6), ' ', substring(name(Statystyki/ActionRole-PlayingGame), 7, 12), ' ', substring(name(Statystyki/ActionRole-PlayingGame), 19, 4))"
                                />
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                <xsl:value-of select="Statystyki/ActionRole-PlayingGame/Ilość"/>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                    <fo:table-row>
                        <fo:table-cell>
                            <fo:block>
                                <xsl:value-of select="concat(substring(name(Statystyki/GraAkcji),1,3), ' ', substring(name(Statystyki/GraAkcji),4,5))"/>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                <xsl:value-of select="Statystyki/GraAkcji/Ilość"/>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                    <fo:table-row>
                        <fo:table-cell>
                            <fo:block>
                                <xsl:value-of select="name(Statystyki/Platformowe)"/>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                <xsl:value-of select="Statystyki/Platformowe/Ilość"/>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>
        </fo:block>
    </xsl:template>

</xsl:stylesheet>
