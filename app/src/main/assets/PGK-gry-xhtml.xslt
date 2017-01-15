<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
  <xsl:output method="xml" version="1.0" encoding="utf-8"
    doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"
    doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" />

  <xsl:template match="/">
    <html xmlns="http://www.w3.org/1999/xhtml">
      <xsl:copy-of select="document('')/xsl:stylesheet/namespace::*[not(local-name() = 'xsl')]"/>
      <xsl:attribute name="xml:lang">pl</xsl:attribute>
      <xsl:attribute name="lang">pl</xsl:attribute>
      <head>
        <title>
          <xsl:text>Gry</xsl:text>
        </title>
        <meta http-equiv="Content-type" content="text/xhtml; charset=utf-8" lang="PL"/>
      </head>
      <body>
        <p>
          <a name="Home">Gry</a>
        </p>
        <p>
          <img src="http://www.spidersweb.pl/wp-content/themes/new_sw_v3_git/images/dzialy/xgry.png.pagespeed.ic.5b1G4Qj82N.png" alt="Gry" height="200" width="300"/>
        </p>
        <p>
          <a href="#Autorzy">Autorzy</a>
        </p>
        <p>
          <a href="#Firmy">Firmy</a>
        </p>
        <p>
          <a name="Autorzy">
            <b>Autorzy</b>
          </a>
        </p>
        <table border="2">
          <tr>
            <th>Indeks</th>
            <th>Imię</th>
            <th>Nazwisko</th>
          </tr>
          <xsl:for-each select="//Gry/OgólneInformacje/Autorzy/Autor">
            <tr>
              <td>
                <xsl:value-of select="./Indeks"/>
              </td>
              <td>
                <xsl:value-of select="./Imię"/>
              </td>
              <td>
                <xsl:value-of select="./Nazwisko"/>
              </td>
            </tr>
          </xsl:for-each>
        </table>
        <p>
          <a name="Firmy">
            <b>Firmy</b>
          </a>
        </p>
        <table border="2">
          <tr>
            <th>Firma</th>
            <th>Gry</th>
          </tr>
          <xsl:for-each select="//Gry/ListaFirm/Firma">
            <tr>
              <td>
                <xsl:value-of select="concat(./Nazwa, ', ', ./Lokalizacja, ', ', ./DataZałożenia)"/>
              </td>
              <td>
                <table border="1">
                  <xsl:for-each select="./ListaGier/Gra">
                    <tr>
                      <td>
                        <xsl:value-of select="./Nazwa"/>
                      </td>
                      <td>
                        <xsl:value-of select="./RokWydania"/>
                      </td>
                      <td>
                        <xsl:value-of select="./Gatunek"/>
                      </td>
                      <td>
                        <xsl:value-of select="./Cena"/>
                      </td>
                    </tr>
                  </xsl:for-each>
                </table>
              </td>
            </tr>
          </xsl:for-each>
        </table>
        <p>
          <b>Podsumowanie</b>
        </p>
        <table border="2">
          <tr>
            <xsl:for-each select="//Gry/Podsumowanie/Statystyki/*">
              <th>
                <xsl:value-of select="name(.)"/>
              </th>
            </xsl:for-each>
          </tr>
          <tr>
            <xsl:for-each select="//Gry/Podsumowanie/Statystyki/*">
              <td>
                <xsl:value-of select="./Ilość"/>
              </td>
            </xsl:for-each>
          </tr>
        </table>
        <p>
          <a>
            <xsl:value-of select="concat('Data Raportu: ', //Gry/Podsumowanie/DataRaportu)"/>
          </a>
        </p>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
