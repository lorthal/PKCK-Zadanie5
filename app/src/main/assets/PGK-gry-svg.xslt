<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:svg="http://www.w3.org/2000/svg" version="1.0"
    xmlns:xlink="http://www.w3.org/1999/xlink">
    
    <xsl:output method="xml" media-type="image/svg" encoding="UTF-8"/>
    
    <xsl:template match="/">
        <svg:svg width="800" height="600" font-family="Calibri">
            <svg:desc>
                Dane o grach w firmach
            </svg:desc>
            <svg:title>Gry</svg:title>
            
            <svg:rect x="3"  y="3" width="794" height="594" fill="orange" stroke="black" stroke-width="3"/>
            <svg:text x="50%" y="5%" font-size="18" fill="black" font-weight="bold" text-anchor="middle">
                Dane o grach w firmach
            </svg:text>
            <svg:rect x="10%" y="10%" width="80%" height="80%" stroke="black" fill="yellow" stroke-width="3"/>
            <svg:text text-anchor="middle" x="50%" y="15%" font-size="18" fill="black" font-weight="bold">Gatunki</svg:text>
            <svg:text text-anchor="middle" x="25%" y="85%" font-size="18" fill="black" font-weight="bold">Gry Akcji</svg:text>
            <svg:text text-anchor="middle" x="75%" y="85%" font-size="18" fill="black" font-weight="bold">Action Role-Playing Game</svg:text>
            <svg:text text-anchor="middle" x="50%" y="85%" font-size="18" fill="black" font-weight="bold">Platformowe</svg:text>
            
            <svg:text text-anchor="middle" x="15%" y="70%" font-size="18" fill="black" font-weight="bold">1</svg:text>
            <svg:text text-anchor="middle" x="15%" y="55%" font-size="18" fill="black" font-weight="bold">2</svg:text>
            <svg:text text-anchor="middle" x="15%" y="40%" font-size="18" fill="black" font-weight="bold">3</svg:text>
            <svg:text text-anchor="middle" x="15%" y="25%" font-size="18" fill="black" font-weight="bold">4</svg:text>
            
            <svg:line x1="18%" x2="85%" y1="80%" y2="80%" stroke="black" stroke-width="2"></svg:line>
            
            <svg:line x1="18%" x2="18%" y1="20%" y2="80%" stroke="black" stroke-width="2"></svg:line>
            
            <svg:line x1="18%" x2="85%" y1="70%" y2="70%" stroke="black" stroke-width="2" stroke-dasharray="5,5"></svg:line>
            <svg:line x1="18%" x2="85%" y1="55%" y2="55%" stroke="black" stroke-width="2" stroke-dasharray="5,5"></svg:line>
            <svg:line x1="18%" x2="85%" y1="40%" y2="40%" stroke="black" stroke-width="2" stroke-dasharray="5,5"></svg:line>
            <svg:line x1="18%" x2="85%" y1="25%" y2="25%" stroke="black" stroke-width="2" stroke-dasharray="5,5"></svg:line>
            
            
            <xsl:choose>
                <xsl:when test="//Podsumowanie/Statystyki/GraAkcji/Ilość = 1">
                    <svg:rect x="20%" y="80%" width="15%" height="0%" fill="blue">
                        <svg:animate id="ga1" fill="freeze" attributeName="y" from="80%" to="70%" dur="1s"></svg:animate>
                        <svg:animate id="ga2" fill="freeze" attributeName="height" from="0%" to="10%" dur="1s"></svg:animate>
                    </svg:rect>
                </xsl:when>
                <xsl:when test="//Podsumowanie/Statystyki/GraAkcji/Ilość = 2">
                    <svg:rect x="20%" y="80%" width="15%" height="0%" fill="blue">
                        <svg:animate id="ga3" fill="freeze" attributeName="y" from="80%" to="55%" dur="1s"></svg:animate>
                        <svg:animate id="ga4" fill="freeze" attributeName="height" from="0%" to="25%" dur="1s"></svg:animate>
                    </svg:rect>
                </xsl:when>
                <xsl:when test="//Podsumowanie/Statystyki/GraAkcji/Ilość = 3">
                    <svg:rect x="20%" y="80%" width="15%" height="0%" fill="blue">
                        <svg:animate id="ga5" fill="freeze" attributeName="y" from="80%" to="40%" dur="1s"></svg:animate>
                        <svg:animate id="ga6" fill="freeze" attributeName="height" from="0%" to="40%" dur="1s"></svg:animate>
                    </svg:rect>
                </xsl:when>
            </xsl:choose>
            
            <xsl:choose>
                <xsl:when test="//Podsumowanie/Statystyki/Platformowe/Ilość = 1">
                    <svg:rect x="43%" y="80%" width="15%" height="0%" fill="green">
                        <svg:animate id="p1" fill="freeze" attributeName="y" from="80%" to="70%" dur="1s"></svg:animate>
                        <svg:animate id="p2" fill="freeze" attributeName="height" from="0%" to="10%" dur="1s"></svg:animate>
                    </svg:rect>
                </xsl:when>
                <xsl:when test="//Podsumowanie/Statystyki/Platformowe/Ilość = 2">
                    <svg:rect x="43%" y="80%" width="15%" height="0%" fill="green">
                        <svg:animate id="p3" fill="freeze" attributeName="y" from="80%" to="55%" dur="1s"></svg:animate>
                        <svg:animate id="p4" fill="freeze" attributeName="height" from="0%" to="25%" dur="1s"></svg:animate>
                    </svg:rect>
                </xsl:when>
                <xsl:when test="//Podsumowanie/Statystyki/Platformowe/Ilość = 3">
                    <svg:rect x="43%" y="80%" width="15%" height="0%" fill="green">
                        <svg:animate id="p5" fill="freeze" attributeName="y" from="80%" to="40%" dur="1s"></svg:animate>
                        <svg:animate id="p6" fill="freeze" attributeName="height" from="0%" to="40%" dur="1s"></svg:animate>
                    </svg:rect>
                </xsl:when>
            </xsl:choose>
            
            <xsl:choose>
                <xsl:when test="//Podsumowanie/Statystyki/ActionRole-PlayingGame/Ilość = 1">
                    <svg:rect x="68%" y="80%" width="15%" height="0%" fill="red">
                        <svg:animate id="arpg1" fill="freeze" attributeName="y" from="80%" to="70%" dur="1s"></svg:animate>
                        <svg:animate id="arpg2" fill="freeze" attributeName="height" from="0%" to="10%" dur="1s"></svg:animate>
                    </svg:rect>
                </xsl:when>
                <xsl:when test="//Podsumowanie/Statystyki/ActionRole-PlayingGame/Ilość = 2">
                    <svg:rect x="68%" y="80%" width="15%" height="0%" fill="red">
                        <svg:animate id="arpg3" fill="freeze" attributeName="y" from="80%" to="55%" dur="1s"></svg:animate>
                        <svg:animate id="arpg4" fill="freeze" attributeName="height" from="0%" to="25%" dur="1s"></svg:animate>
                    </svg:rect>
                </xsl:when>
                <xsl:when test="//Podsumowanie/Statystyki/ActionRole-PlayingGame/Ilość = 3">
                    <svg:rect x="68%" y="80%" width="15%" height="0%" fill="red">
                        <svg:animate id="arpg5" fill="freeze" attributeName="y" from="80%" to="40%" dur="1s"></svg:animate>
                        <svg:animate id="arpg6" fill="freeze" attributeName="height" from="0%" to="40%" dur="1s"></svg:animate>
                    </svg:rect>
                </xsl:when>
            </xsl:choose>
        </svg:svg>
    </xsl:template>
    
</xsl:stylesheet>