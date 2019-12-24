Android uygulamada ekranda iki farklı
fragment bulunmaktadır. Sol tarafta Android versiyonlarını listeleyen bir fragment (FragmentVersion),
hemen sağında ise ayrı bir fragment (FragmentDetail) vardır. Bu iki fragment MainActivity adındaki bir
aktivitede sabit (static) birer fragment viewi olarak ekranda görüldüğü gibi yerleştirilmiştir.
FragmentVersion çalıştığında;
http://web.karabuk.edu.tr/yasinortakci/dokumanlar/web_dokumanlari/AndroidVersion.json adresinden
JSON formatındaki verileri çekerek, bir listviewde her bir Android versiyonunun ismini listelemektedir.
FragmentVersion’da herhangi bir Android versiyonuna tıklandığında o versiyonun ismi, versiyon
numarası ve API numarası sağ taraftaki FramgentDetail fragmanına gönderilmekte ve fragment
ekranında görüntülenmektedir.
