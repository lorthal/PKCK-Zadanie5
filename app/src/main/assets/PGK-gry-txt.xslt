<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
    <xsl:output method="text" xml:base="result.xml"/>

  <xsl:template match="node/@TEXT | text()">
    <xsl:if test="normalize-space(.)">
      <xsl:value-of select="concat(normalize-space(.), '&#10;')"/>
    </xsl:if>
    <xsl:apply-templates />
  </xsl:template>

  <xsl:template match="/">
    
    <xsl:text>GRY:&#xA;</xsl:text>
    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template match="//Autorzy">
    <xsl:text>&#xA;++AUTORZY++&#xA;----------------------------------------------------------------------&#xA;</xsl:text>
    <xsl:for-each select="Autor">
      <xsl:value-of select="concat('| ', Indeks,' ', Imię,' ', Nazwisko)"/>
      <xsl:text>&#xA;</xsl:text>
    </xsl:for-each>
    <xsl:text>----------------------------------------------------------------------&#xA;</xsl:text>
  </xsl:template>

  <xsl:template match="//ListaFirm">
    <xsl:text>&#xA;</xsl:text>
    <xsl:text>++FIRMY++&#xA;----------------------------------------------------------------------&#xA;</xsl:text>
    <xsl:for-each select="Firma">
      <xsl:value-of select="concat('| ',Nazwa, ' ',Lokalizacja, ' ',DataZałożenia)"/>
      <xsl:text>&#xA;</xsl:text>
      <xsl:apply-templates select="ListaGier"/>
      
    </xsl:for-each>
    <xsl:text>----------------------------------------------------------------------&#xA;</xsl:text>
  </xsl:template>
  
  <xsl:template match="//ListaGier">
    <xsl:for-each select="Gra">
      <xsl:value-of select="concat('|--- ', Nazwa, ' ', RokWydania, ' ', Gatunek, ' ', Cena, ' ', IlośćSztuk)"/>
      <xsl:text>&#xA;</xsl:text>
    </xsl:for-each>
  </xsl:template>
  
  <xsl:template match="//Podsumowanie">
    <xsl:text>&#xA;++PODSUMOWANIE++&#xA;----------------------------------------------------------------------&#xA;</xsl:text>
    <xsl:for-each select="Statystyki/GraAkcji">
      <xsl:value-of select="concat('| ', 'Gry Akcji:', ' ', Ilość)"/>
      <xsl:text>&#xA;</xsl:text>
    </xsl:for-each>
    <xsl:for-each select="Statystyki/Platformowe">
      <xsl:value-of select="concat('| ', name(), ': ', Ilość)"/>
      <xsl:text>&#xA;</xsl:text>
    </xsl:for-each>
    <xsl:for-each select="Statystyki/ActionRole-PlayingGame">
      <xsl:value-of select="concat('| ', 'Action Role-Playing Game', ': ', Ilość)"/>
      <xsl:text>&#xA;</xsl:text>
    </xsl:for-each>
    <xsl:text>----------------------------------------------------------------------&#xA;</xsl:text>
    <xsl:apply-templates select="DataRaportu"/>
  </xsl:template>
  
  <xsl:template match="DataRaportu">
    <xsl:text>**DATA RAPORTU: </xsl:text>
    <xsl:value-of select="concat(substring(.,9,2), '.', substring(.,6,2), '.', substring(., 0,5), '  ',substring(.,12,5))"/>
  </xsl:template>

</xsl:stylesheet>
