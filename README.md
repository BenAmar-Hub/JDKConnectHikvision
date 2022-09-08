# JDKConnectHikvision
Demo Connexion Hikvision
**1. installer le Protocole SADP pour gérer n'importe quel device hikvision:
**link:https://www.hikvision.com/en/support/tools/hitools/clea8b3e4ea7da90a9/
2. ****dans une seconde étape connecter votre pc directement avec l'appareil hikvision et configurer un réseau local :
ip device configurer sur 192.0.0.64 vous pouvez le modifier à partir de SADP
l'administrateur configurer sur le device avec :
login:admin et password:a1234b5678
NB: si le login admin n'est pas pris en compte vous changer l'authentification sur le device par user1
**3. vous devez aussi télécharger le hcnetsdkv6.1.9 et dedans vous trouvez les fichiers librairies du C++ :
comme par exemple hcnetsdk.h qui contient ttes les structures et interfaces nécessaire pour mapper vers hcnetsdk.java**
