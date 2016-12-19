package hci.cityplanner;

import org.json.*;

import java.util.HashMap;

/**
 * Created by Sander on 19-12-2016.
 */

public class JSONHelper {
    public HashMap<String, Highlight> parseJSON() {
        HashMap<String, Highlight> result = new HashMap<>();
        String input = "{\n" +
                "  \"Sheet1\": [\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Food\",\n" +
                "      \"Name\": \"Boutary\",\n" +
                "      \"Description\": \"French kitchen, fish and seafood\",\n" +
                "      \"Lattitude\": \"48.8549058\",\n" +
                "      \"Longtitude\": \"2.3358669\",\n" +
                "      \"(Expensiveness)\": \"€€€€\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Food\",\n" +
                "      \"Name\": \"Epicure\",\n" +
                "      \"Description\": \"French and European kitchen\",\n" +
                "      \"Lattitude\": \"48.8718349\",\n" +
                "      \"Longtitude\": \"2.3194468\",\n" +
                "      \"(Expensiveness)\": \"€€€€\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Food\",\n" +
                "      \"Name\": \"Il Etait Un Square\",\n" +
                "      \"Description\": \"European kitchen\",\n" +
                "      \"Lattitude\": \"48.8310182\",\n" +
                "      \"Longtitude\": \"2.3457476\",\n" +
                "      \"(Expensiveness)\": \"€€ - €€€\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Food\",\n" +
                "      \"Name\": \"Midi 12\",\n" +
                "      \"Description\": \"French and European kitchen\",\n" +
                "      \"Lattitude\": \"48.8733635\",\n" +
                "      \"Longtitude\": \"2.3325573\",\n" +
                "      \"(Expensiveness)\": \"€\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Food\",\n" +
                "      \"Name\": \"McDonald's\",\n" +
                "      \"Description\": \"European and American kitchen\",\n" +
                "      \"Lattitude\": \"48.8488489\",\n" +
                "      \"Longtitude\": \"2.2956638\",\n" +
                "      \"(Expensiveness)\": \"€\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Culture\",\n" +
                "      \"Name\": \"Eiffel Tower\",\n" +
                "      \"Description\": \"The Eiffel Tower (/ˈaɪfəl ˈtaʊər/ eye-fəl towr; French: Tour Eiffel, pronounced: [tuʁ‿ɛfɛl] About this sound listen) is a wrought iron lattice tower on the Champ de Mars in Paris, France. It is named after the engineer Gustave Eiffel, whose company designed and built the tower.\\r\\n\\r\\nConstructed from 1887–89 as the entrance to the 1889 World's Fair, it was initially criticized by some of France's leading artists and intellectuals for its design, but it has become a global cultural icon of France and one of the most recognisable structures in the world. The Eiffel Tower is the most-visited paid monument in the world; 6.91 million people ascended it in 2015.\\r\\n\\r\\nThe tower is 324 metres (1,063 ft) tall, about the same height as an 81-storey building, and the tallest structure in Paris. Its base is square, measuring 125 metres (410 ft) on each side. During its construction, the Eiffel Tower surpassed the Washington Monument to become the tallest man-made structure in the world, a title it held for 41 years until the Chrysler Building in New York City was finished in 1930. Due to the addition of a broadcasting aerial at the top of the tower in 1957, it is now taller than the Chrysler Building by 5.2 metres (17 ft). Excluding transmitters, the Eiffel Tower is the second-tallest structure in France after the Millau Viaduct.\\r\\n\\r\\nThe tower has three levels for visitors, with restaurants on the first and second levels. The top level's upper platform is 276 m (906 ft) above the ground – the highest observation deck accessible to the public in the European Union. Tickets can be purchased to ascend by stairs or lift (elevator) to the first and second levels. The climb from ground level to the first level is over 300 steps, as is the climb from the first level to the second. Although there is a staircase to the top level, it is usually only accessible by lift.\",\n" +
                "      \"Lattitude\": \"48.8587911\",\n" +
                "      \"Longtitude\": \"2.2908959\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Culture\",\n" +
                "      \"Name\": \"Musée d'Orsay\",\n" +
                "      \"Description\": \"The Musée d'Orsay (French pronunciation: \u200B[myze dɔʁsɛ]) is a museum in Paris, France, on the left bank of the Seine. It is housed in the former Gare d'Orsay, a Beaux-Arts railway station built between 1898 and 1900. The museum holds mainly French art dating from 1848 to 1914, including paintings, sculptures, furniture, and photography. It houses the largest collection of impressionist and post-Impressionist masterpieces in the world, by painters including Monet, Manet, Degas, Renoir, Cézanne, Seurat, Sisley, Gauguin, and Van Gogh. Many of these works were held at the Galerie nationale du Jeu de Paume prior to the museum's opening in 1986. It is one of the largest art museums in Europe.\",\n" +
                "      \"Lattitude\": \"48.8599649\",\n" +
                "      \"Longtitude\": \"2.3243727\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Culture\",\n" +
                "      \"Name\": \"Louvre\",\n" +
                "      \"Description\": \"The Louvre or the Louvre Museum (French: Musée du Louvre, pronounced: [myze dy luvʁ]) (French About this sound  (help·info)) is the world's largest museum and a historic monument in Paris, France. A central landmark of the city, it is located on the Right Bank of the Seine in the city's 1st arrondissement (district or ward). Nearly 35,000 objects from prehistory to the 21st century are exhibited over an area of 72,735 square metres (782,910 square feet).[2] The Louvre is the world's second most visited museum after the Palace Museum in China, receiving more than 9.26 million visitors in 2014.[1]\\r\\n\\r\\nThe museum is housed in the Louvre Palace, originally built as a fortress in the late 12th century under Philip II. Remnants of the fortress are visible in the basement of the museum. Due to the urban expansion of the city, the fortress eventually lost its defensive function and, in 1546, was converted by Francis I into the main residence of the French Kings.[3] The building was extended many times to form the present Louvre Palace. In 1682, Louis XIV chose the Palace of Versailles for his household, leaving the Louvre primarily as a place to display the royal collection, including, from 1692, a collection of ancient Greek and Roman sculpture.[4] In 1692, the building was occupied by the Académie des Inscriptions et Belles Lettres and the Académie Royale de Peinture et de Sculpture, which in 1699 held the first of a series of salons. The Académie remained at the Louvre for 100 years.[5] During the French Revolution, the National Assembly decreed that the Louvre should be used as a museum to display the nation's masterpieces.\\r\\n\\r\\nThe museum opened on 10 August 1793 with an exhibition of 537 paintings, the majority of the works being royal and confiscated church property. Because of structural problems with the building, the museum was closed in 1796 until 1801. The collection was increased under Napoleon and the museum renamed the Musée Napoléon, but after Napoleon's abdication many works seized by his armies were returned to their original owners. The collection was further increased during the reigns of Louis XVIII and Charles X, and during the Second French Empire the museum gained 20,000 pieces. Holdings have grown steadily through donations and bequests since the Third Republic. The collection is divided among eight curatorial departments: Egyptian Antiquities; Near Eastern Antiquities; Greek, Etruscan and Roman Antiquities; Islamic Art; Sculpture; Decorative Arts; Paintings; Prints and Drawings.\",\n" +
                "      \"Lattitude\": \"48.8606146\",\n" +
                "      \"Longtitude\": \"2.3354553\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Culture\",\n" +
                "      \"Name\": \"Notre Dame\",\n" +
                "      \"Description\": \"Notre-Dame de Paris (French: [nɔtʁə dam də paʁi] ( listen); meaning \\\"Our Lady of Paris\\\"), also known as Notre-Dame Cathedral or simply Notre-Dame, is a medieval Catholic cathedral on the Île de la Cité in the fourth arrondissement of Paris, France. The cathedral is widely considered to be one of the finest examples of French Gothic architecture, and is among the largest and most well-known church buildings in the world. The naturalism of its sculptures and stained glass are in contrast with earlier Romanesque architecture.\\r\\n\\r\\nAs the cathedral of the Archdiocese of Paris, Notre-Dame contains the cathedra of the Archbishop of Paris, currently Cardinal André Vingt-Trois. The cathedral treasury contains a reliquary which houses some of Catholicism's most important relics, including the purported Crown of Thorns, a fragment of the True Cross, and one of the Holy Nails.\\r\\n\\r\\nIn the 1790s, Notre-Dame suffered desecration in the radical phase of the French Revolution when much of its religious imagery was damaged or destroyed. An extensive restoration supervised by Eugène Viollet-le-Duc began in 1845. A project of further restoration and maintenance began in 1991.\",\n" +
                "      \"Lattitude\": \"48.85234\",\n" +
                "      \"Longtitude\": \"2.3482876\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Culture\",\n" +
                "      \"Name\": \"Arc de Triomphe\",\n" +
                "      \"Description\": \"The Arc de Triomphe de l'Étoile (French pronunciation: [aʁk də tʁijɔ̃f də letwal] ( listen), Triumphal Arch of the Star) is one of the most famous monuments in Paris, standing at the western end of the Champs-Élysées at the center of Place Charles de Gaulle, formerly named Place de l'Étoile — the étoile or \\\"star\\\" of the juncture formed by its twelve radiating avenues.\\r\\n\\r\\nThe Arc de Triomphe should not be confused with a smaller arch, the Arc de Triomphe du Carrousel, which stands west of the Louvre. The Arc de Triomphe honours those who fought and died for France in the French Revolutionary and the Napoleonic Wars, with the names of all French victories and generals inscribed on its inner and outer surfaces. Beneath its vault lies the Tomb of the Unknown Soldier from World War I.\\r\\n\\r\\nAs the central cohesive element of the Axe historique (historic axis, a sequence of monuments and grand thoroughfares on a route which runs from the courtyard of the Louvre to the Grande Arche de la Défense, the Arc de Triomphe was designed by Jean Chalgrin in 1806 and its iconographic program pits heroically nude French youths against bearded Germanic warriors in chain mail. It set the tone for public monuments with triumphant patriotic messages.\\r\\n\\r\\nInspired by the Roman Arch of Titus, the Arc de Triomphe has an overall height of 50 metres (164 ft), width of 45 m (148 ft) and depth of 22 m (72 ft), while its large vault is 29.19 m (95.8 ft) high and 14.62 m (48.0 ft) wide. The smaller transverse vaults are 18.68 m (61.3 ft) high and 8.44 m (27.7 ft) wide. Three weeks after the Paris victory parade in 1919 (marking the end of hostilities in World War I), Charles Godefroy flew his Nieuport biplane under the arch's primary vault, with the event captured on newsreel.\\r\\n\\r\\nParis's Arch de Triomphe was the tallest triumphal arch until the completion of the Monumento a la Revolución in Mexico City in 1938, which is 67 metres (220 ft) high. The Arch of Triumph in Pyongyang, completed in 1982, is modelled on the Arc de Triomphe and is slightly taller at 60 m (197 ft).\",\n" +
                "      \"Lattitude\": \"48.8737828\",\n" +
                "      \"Longtitude\": \"2.2928269\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Nature\",\n" +
                "      \"Name\": \"Jardin du Luxembourg\",\n" +
                "      \"Description\": \"The Jardin du Luxembourg, or the Luxembourg Garden, located in the 6th arrondissement of Paris, was created beginning in 1612 by Marie de' Medici, the widow of King Henry IV of France, for a new residence she constructed, the Luxembourg Palace. The garden today is owned by the French Senate, which meets in the Palace. It covers 23 hectares and is known for its lawns, tree-lined promenades, flowerbeds, the model sailboats on its circular basin, and for the picturesque Medici Fountain, built in 1620.\",\n" +
                "      \"Lattitude\": \"48.8457884\",\n" +
                "      \"Longtitude\": \"2.329917\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Nature\",\n" +
                "      \"Name\": \"River Seine\",\n" +
                "      \"Description\": \"The Seine (/seɪn/ sayn; French: La Seine, pronounced: [la sɛːn]) is a 777-kilometre (483 mi) long river and an important commercial waterway within the Paris Basin in the north of France. It rises at Source-Seine, 30 kilometres (19 mi) northwest of Dijon in northeastern France in the Langres plateau, flowing through Paris and into the English Channel at Le Havre (and Honfleur on the left bank). It is navigable by ocean-going vessels as far as Rouen, 120 kilometres (75 mi) from the sea. Over 60 percent of its length, as far as Burgundy, is negotiable by commercial riverboats and nearly its whole length is available for recreational boating; excursion boats offer sightseeing tours of the Rive Droite and Rive Gauche within the city of Paris.\\r\\n\\r\\nThere are 37 bridges within Paris and dozens more spanning the river outside the city. Examples in Paris include the Pont Alexandre III and Pont Neuf, the latter of which dates back to 1607. Outside the city, examples include the Pont de Normandie, one of the longest cable-stayed bridges in the world, which links Le Havre to Honfleur.\",\n" +
                "      \"Lattitude\": \"48.858809\",\n" +
                "      \"Longtitude\": \"2.335438\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Nature\",\n" +
                "      \"Name\": \"Jardin des Tuileries\",\n" +
                "      \"Description\": \"The Tuileries Garden (French: Jardin des Tuileries, IPA: [ʒaʁdɛ̃ de tɥilʁi]) is a public garden located between the Louvre Museum and the Place de la Concorde in the 1st arrondissement of Paris. Created by Catherine de Medici as the garden of the Tuileries Palace in 1564, it was eventually opened to the public in 1667, and became a public park after the French Revolution. In the 19th and 20th century, it was the place where Parisians celebrated, met, promenaded, and relaxed.\",\n" +
                "      \"Lattitude\": \"48.8631093\",\n" +
                "      \"Longtitude\": \"2.2879807\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Nature\",\n" +
                "      \"Name\": \"Parc des Buttes Chaumont\",\n" +
                "      \"Description\": \"The Parc des Buttes-Chaumont (pronounced: [paʁk de byt ʃomɔ̃]) is a public park situated in northeastern Paris, in the 19th arrondissement. Occupying 24.7 hectares (61 acres), it is the fifth-largest park in Paris, after the Bois de Vincennes, the Bois de Boulogne, the Parc de la Villette, and the Tuileries Garden. It was opened in 1867, late in the regime of Emperor Napoleon III, and was built by Jean-Charles Alphand, who created all the major parks of Napoleon III. The park has 5.5 kilometres (3.4 miles) of roads and 2.2 kilometres (1.4 miles) of paths. The most famous feature of the park is the Temple de la Sibylle, inspired by the Temple of Vesta in Tivoli, Italy, perched at the top of a cliff fifty metres above the waters of the artificial lake.\",\n" +
                "      \"Lattitude\": \"48.8809531\",\n" +
                "      \"Longtitude\": \"2.3805722\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Nature\",\n" +
                "      \"Name\": \"Parc Montsouris\",\n" +
                "      \"Description\": \"Parc Montsouris is a public park in the 14th arrondissement of Paris, at the southern edge of Paris directly south of the center. Opened in 1869, Parc Montsouris is one of the four large urban public parks, along with the Bois de Boulogne, the Bois de Vincennes and the Parc des Buttes Chaumont, created by Emperor Napoleon III and his Prefect of the Seine, Baron Haussmann, at each of the cardinal points of the compass around the city, in order to provide green space and recreation for the rapidly growing population of Paris. The park is 15.5 hectares in area, and is designed as an English landscape garden.\\r\\n\\r\\nThe Park contains a lake, a cascade, wide sloping lawns, and many notable varieties of trees, shrubs and flowers. It is also home to a meteorology station, a cafe and a guignol theater. The roads of the park are extremely popular with joggers on weekends.\\r\\n\\r\\nThe park is bounded to the south by Boulevard Jourdan and the Cité Internationale Universitaire de Paris (CIUP); to the north by Avenue Reille; to the east by Rue Gazan and Rue de la Cité Universitaire; and to the west by Rue Nansouty and Rue Émile Deutsch-de-la-Meurthe.\\r\\n\\r\\nThe \\\"Cité Universitaire\\\" stop on the line on the RER B is located in the center of Parc Montsouris.\",\n" +
                "      \"Lattitude\": \"48.8223097\",\n" +
                "      \"Longtitude\": \"2.3356676\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Shopping\",\n" +
                "      \"Name\": \"Shakespeare and Company Bookstore\",\n" +
                "      \"Description\": \"Shakespeare and Company is the name of two independent English-language bookstores that have existed on Paris's Left Bank.\\r\\n\\r\\nThe first was opened by Sylvia Beach, an American, on 19 November 1919, at 8 rue Dupuytren, before moving to larger premises at 12 rue de l'Odéon in the 6th arrondissement in 1922. During the 1920s, Beach's shop was a gathering place for many then-aspiring writers such as Ezra Pound, Ernest Hemingway, Djuna Barnes, James Joyce and Ford Madox Ford. It closed in 1941 during the German occupation of Paris and never re-opened.\\r\\n\\r\\nThe second bookstore is situated at 37 rue de la Bûcherie, in the 5th arrondissement, and is still in operation today. Opened in 1951 by American George Whitman, it was originally called \\\"Le Mistral,\\\" but was renamed to \\\"Shakespeare and Company\\\" in 1964 in tribute to Sylvia Beach's store and on the 400th anniversary of William Shakespeare's birth. Today, it continues to serve as a purveyor of new and second-hand books, as an antiquarian bookseller, and as a free reading library open to the public. Additionally, the shop houses aspiring writers and artists in exchange for their helping out around the bookstore. Since the shop opened in 1951, more than 30,000 people have slept in the beds found tucked between bookshelves. The shop's motto, \\\"Be Not Inhospitable to Strangers Lest They Be Angels in Disguise,\\\" is written above the entrance to the reading library.\",\n" +
                "      \"Lattitude\": \"48.8525505\",\n" +
                "      \"Longtitude\": \"2.344931\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Shopping\",\n" +
                "      \"Name\": \"Galeries Lafayette\",\n" +
                "      \"Description\": \"The Galeries Lafayette (French pronunciation: \u200B[ɡalʁi lafajɛt]) is an upmarket French department store chain. Its flagship store is on Boulevard Haussmann in the 9th arrondissement of Paris but it now operates in a number of other locations in France and other countries. In 2009, Galeries Lafayette recorded earnings of over one billion euro. It is a part of the company Groupe Galeries Lafayette.\",\n" +
                "      \"Lattitude\": \"48.8530373\",\n" +
                "      \"Longtitude\": \"2.3286652\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Shopping\",\n" +
                "      \"Name\": \"Le Bon Marché Rive Gauche\",\n" +
                "      \"Description\": \"Shopping Mall for luxuary goods.\",\n" +
                "      \"Lattitude\": \"48.8511389\",\n" +
                "      \"Longtitude\": \"2.3221761\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Shopping\",\n" +
                "      \"Name\": \"Champs-Élysées\",\n" +
                "      \"Description\": \"The Avenue des Champs-Élysées (French pronunciation: [av(ə).ny de ʃɑ̃z‿e.li.ze] ( listen)) is an avenue in the 8th arrondissement of Paris, 1.9 kilometres (1.2 mi) long and 70 metres (230 ft) wide, running between the Place de la Concorde and the Place Charles de Gaulle, where the Arc de Triomphe is located. It is known for its theatres, cafés and luxury shops, for the annual Bastille Day military parade, and as the finish of the Tour de France cycle race. The name is French for the Elysian Fields, the paradise for dead heroes in Greek mythology. The French proudly call their world-famous boulevard \\\"la plus belle avenue du monde\\\" (\\\"the world's most beautiful avenue\\\").\",\n" +
                "      \"Lattitude\": \"48.8707876\",\n" +
                "      \"Longtitude\": \"2.3021078\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Paris\",\n" +
                "      \"Category\": \"Shopping\",\n" +
                "      \"Name\": \"Printemps\",\n" +
                "      \"Description\": \"Printemps was founded in 1865 by Jules Jaluzot and Jean-Alfred Duclos. The store was designed by noted architects Jules and Paul Sédille and opened at the corner of Le Havre and Boulevard Haussmann, in Paris, France on 3 November 1865. The building was greatly expanded in 1874, and elevators (then a great novelty) from the 1867 Universal Exposition were installed. Rebuilt after a fire in 1881, the store became the first to use electric lighting, in 1888. (Customers could observe the workings of the power plant behind a glass wall.) It was also one of the first department stores with direct subway access, the Metro being connected in 1904.\\r\\n\\r\\nThe policies of Printemps revolutionized retail business practices. The store marked items with set prices and eschewed the haggling based on customer appearance that had previously been standard in retail shopping. Like other grands magasins (literally \\\"big store\\\", department store), Printemps used the economies of scale to provide high quality goods at prices that the expanding middle class could afford. They also pioneered the idea of discount sales to clear out dated stocks, and later the use of window models to display the latest fashions. Printemps was noted for its branding innovations as well, handing out bouquets of violets on the first day of each Spring and championing the new Art Nouveau style, with its nature inspired motifs.\\r\\n\\r\\nIn 1904, a near collapse of the business led to the resignation of Jules Jaluzot, who was succeeded by Gustave Languionie who the following year announced the construction of a second store. This location, designed by architect Rene Binet, opened five years later and is famously dominated by a glass domed hall 42 meters in height, and a noted Art Nouveau staircase. (Removed in 1955.) The first store outside of Paris was opened in 1912 in Deauville. Peter Laguionie, son of Gustave took the helm of the store in 1920, rebuilding it after another large fire in 1921. In 1931, Printemps created the discount chain Prisunic. By 1970 there were 23 Printemps locations and 13 Prisunic discount outlets. The oil-price driven French economic crisis of the early 1970s significantly threatened Printemps business model. In response, the firm is transformed into a limited corporation, with controlling interest acquired by the Maus Frères, a Swiss holding company. Led by Jean-Jacques Delort the firm embarked on a turnaround strategy, creating specialty stores and brands (such as Armand Thierry clothing) and branching out into retail areas such as food and mail. In the 1980s, the brand went global, opening stores in Japan, Istanbul, Jeddah, Dubai, Singapore and Kuala Lumpur.\",\n" +
                "      \"Lattitude\": \"48.8708423\",\n" +
                "      \"Longtitude\": \"2.2692771\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Food\",\n" +
                "      \"Name\": \"The Cinnamon Club\",\n" +
                "      \"Description\": \"Indian kitchen\",\n" +
                "      \"Lattitude\": \"51.5062813\",\n" +
                "      \"Longtitude\": \"-0.1426948\",\n" +
                "      \"(Expensiveness)\": \"€€-€€€\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Food\",\n" +
                "      \"Name\": \"Hakkasan Hanway Place\",\n" +
                "      \"Description\": \"Chinese kitchen\",\n" +
                "      \"Lattitude\": \"51.5126511\",\n" +
                "      \"Longtitude\": \"-0.1334873\",\n" +
                "      \"(Expensiveness)\": \"€€-€€€\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Food\",\n" +
                "      \"Name\": \"Zizzi\",\n" +
                "      \"Description\": \"Italian kitchen\",\n" +
                "      \"Lattitude\": \"51.4927959\",\n" +
                "      \"Longtitude\": \"-0.2028899\",\n" +
                "      \"(Expensiveness)\": \"€€\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Food\",\n" +
                "      \"Name\": \"Bill's\",\n" +
                "      \"Description\": \"A typical British restaurant\",\n" +
                "      \"Lattitude\": \"51.5085101\",\n" +
                "      \"Longtitude\": \"-0.1527467\",\n" +
                "      \"(Expensiveness)\": \"€\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Food\",\n" +
                "      \"Name\": \"Jamie Oliver's Fifteen\",\n" +
                "      \"Description\": \"A restaurant of the one and only Jamie Oliver, \",\n" +
                "      \"Lattitude\": \"51.5285944\",\n" +
                "      \"Longtitude\": \"-0.092436\",\n" +
                "      \"(Expensiveness)\": \"€€€€\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Culture\",\n" +
                "      \"Name\": \"Tower of London\",\n" +
                "      \"Description\": \"The Tower of London, officially Her Majesty's Royal Palace and Fortress of the Tower of London, is a historic castle located on the north bank of the River Thames in central London. It lies within the London Borough of Tower Hamlets, separated from the eastern edge of the square mile of the City of London by the open space known as Tower Hill.\",\n" +
                "      \"Lattitude\": \"51.5077679\",\n" +
                "      \"Longtitude\": \"-0.0777288\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Culture\",\n" +
                "      \"Name\": \"Churchill Museum and Cabinet War Rooms\",\n" +
                "      \"Description\": \"The Churchill War Rooms is a museum in London and one of the five branches of the Imperial War Museum. The museum comprises the Cabinet War Rooms, a historic underground complex that housed a British government command centre throughout the Second World War, and the Churchill Museum, a biographical museum exploring the life of British statesman Winston Churchill.\",\n" +
                "      \"Lattitude\": \"51.5020637\",\n" +
                "      \"Longtitude\": \"-0.1313959\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Culture\",\n" +
                "      \"Name\": \"Palace of Westminster\",\n" +
                "      \"Description\": \"The Palace of Westminster is the meeting place of the House of Commons and the House of Lords, the two houses of the Parliament of the United Kingdom. Commonly known as the Houses of Parliament after its occupants, it is also known as the 'heart of British politics'.[by whom?] The Palace lies on the north bank of the River Thames in the City of Westminster, in central London.\",\n" +
                "      \"Lattitude\": \"51.4994794\",\n" +
                "      \"Longtitude\": \"-0.1269979\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Culture\",\n" +
                "      \"Name\": \"Tower Bridge\",\n" +
                "      \"Description\": \"Tower Bridge is a combined bascule and suspension bridge in London built in 1886–1894. The bridge crosses the River Thames close to the Tower of London and has become an iconic symbol of London. Tower Bridge is one of five London bridges now owned and maintained by the Bridge House Estates, a charitable trust overseen by the City of London Corporation. It is the only one of the Trust's bridges not to connect the City of London directly to the Southwark bank, as its northern landfall is in Tower Hamlets.\",\n" +
                "      \"Lattitude\": \"51.5054564\",\n" +
                "      \"Longtitude\": \"-0.0775452\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Culture\",\n" +
                "      \"Name\": \"The London Eye\",\n" +
                "      \"Description\": \"The London Eye is a giant Ferris wheel on the South Bank of the River Thames in London. Also known as the Millennium Wheel, it has also been called by its owners the British Airways London Eye, then the Merlin Entertainments London Eye, then the EDF Energy London Eye. Since mid-January 2015, it has been known as the Coca-Cola London Eye, following an agreement signed in September 2014.\",\n" +
                "      \"Lattitude\": \"51.503324\",\n" +
                "      \"Longtitude\": \"-0.1217317\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Nature\",\n" +
                "      \"Name\": \"St. James's Park\",\n" +
                "      \"Description\": \"St James's Park is a 23-hectare (57-acre) park in the City of Westminster, central London. The park lies at the southernmost tip of the St James's area, which was named after a leper hospital dedicated to St James the Less. The park is the most easterly of a near-continuous chain of parks that comprises (moving westward) Green Park, Hyde Park, and Kensington Gardens.\",\n" +
                "      \"Lattitude\": \"51.5024597\",\n" +
                "      \"Longtitude\": \"-0.1369996\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Nature\",\n" +
                "      \"Name\": \"Hyde Park\",\n" +
                "      \"Description\": \"Hyde Park is one of the largest parks in London and one of its Royal Parks. The park is the largest of four that form a chain from the entrance of Kensington Palace through Kensington Gardens and Hyde Park, via Hyde Park Corner and Green Park past the main entrance to Buckingham Palace and on through Saint James's Park to Horse Guards Parade in Whitehall. The park is divided by the Serpentine and the Long Water.\",\n" +
                "      \"Lattitude\": \"51.5072682\",\n" +
                "      \"Longtitude\": \"-0.167919\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Nature\",\n" +
                "      \"Name\": \"Regent's Park\",\n" +
                "      \"Description\": \"egent's Park (officially The Regent's Park) is one of the Royal Parks of London. It lies within north-west London, partly in the City of Westminster and partly in the London Borough of Camden. The population of the Westminster ward at the 2011 Census was 13,528. The population of the Camden Ward at the 2011 Census was 13,528. It contains Regent's University London and the London Zoo.\",\n" +
                "      \"Lattitude\": \"51.5312705\",\n" +
                "      \"Longtitude\": \"-0.1591581\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Nature\",\n" +
                "      \"Name\": \"Kensington Gardens\",\n" +
                "      \"Description\": \"Kensington Gardens, once the private gardens of Kensington Palace, are one of the Royal Parks of London, lying immediately to the west of Hyde Park. It is shared between the City of Westminster and the Royal Borough of Kensington and Chelsea, lying within western central London. The park covers an area of 111 hectares (270 acres).[1] The open spaces of Kensington Gardens, Hyde Park, Green Park and St. James's Park together form an almost continuous \\\"green lung\\\" in the heart of London between Kensington and Westminster.\",\n" +
                "      \"Lattitude\": \"51.506987\",\n" +
                "      \"Longtitude\": \"-0.1813537\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Nature\",\n" +
                "      \"Name\": \"Greenwich Park\",\n" +
                "      \"Description\": \"Greenwich Park is a former hunting park in Greenwich and one of the largest single green spaces in south-east London. One of the Royal Parks of London, and the first to be enclosed (in 1433), it covers 74 hectares (180 acres), and is part of the Greenwich World Heritage Site. It commands fine views over the River Thames, the Isle of Dogs and the City of London. The park is open from 06:00 for pedestrians (and 07:00 for traffic) all year round and closes at dusk.\",\n" +
                "      \"Lattitude\": \"51.4769095\",\n" +
                "      \"Longtitude\": \"-0.0007244\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Shopping\",\n" +
                "      \"Name\": \"Borough Market\",\n" +
                "      \"Description\": \"Borough Market is a wholesale and retail food market in Southwark, Central London, England. It is one of the largest and oldest food markets in London.[1][2] In 2014, it celebrated its 1,000th birthday.[3]\",\n" +
                "      \"Lattitude\": \"51.5053812\",\n" +
                "      \"Longtitude\": \"-0.0925953\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Shopping\",\n" +
                "      \"Name\": \"Camden Market\",\n" +
                "      \"Description\": \"The Camden markets are a number of adjoining large retail markets in Camden Town near the Hampstead Road Lock of the Regent's Canal (popularly referred to as Camden Lock), often collectively named \\\"Camden Market\\\" or \\\"Camden Lock\\\". Among products sold on the stalls are crafts, clothing, bric-a-brac, and fast food. It is the fourth-most popular visitor attraction in London, attracting approximately 100,000 people each weekend.\",\n" +
                "      \"Lattitude\": \"51.5419\",\n" +
                "      \"Longtitude\": \"-0.1486463\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Shopping\",\n" +
                "      \"Name\": \"Covent Garden\",\n" +
                "      \"Description\": \"Covent Garden (/ˈkɒvənt/ or /ˈkʌvənt/) is a district in London on the eastern fringes of the West End, between St. Martin's Lane and Drury Lane.[1] It is associated with the former fruit-and-vegetable market in the central square, now a popular shopping and tourist site, and with the Royal Opera House, which is also known as \\\"Covent Garden\\\". The district is divided by the main thoroughfare of Long Acre, north of which is given over to independent shops centred on Neal's Yard and Seven Dials, while the south contains the central square with its street performers and most of the elegant buildings, theatres and entertainment facilities, including the Theatre Royal, Drury Lane and the London Transport Museum.\",\n" +
                "      \"Lattitude\": \"51.5117321\",\n" +
                "      \"Longtitude\": \"-0.1254584\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Shopping\",\n" +
                "      \"Name\": \"Harrods\",\n" +
                "      \"Description\": \"Harrods is a department store located on Brompton Road in Knightsbridge, London. It is owned by the state of Qatar. The Harrods brand also applies to other enterprises undertaken by the Harrods group of companies including Harrods Bank, Harrods Estates, Harrods Aviation and Air Harrods, and to Harrods Buenos Aires, sold by Harrods in 1922 and closed as of 2011, with plans announced to reopen in 2013.[1]\",\n" +
                "      \"Lattitude\": \"51.4994055\",\n" +
                "      \"Longtitude\": \"-0.1654231\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"London\",\n" +
                "      \"Category\": \"Shopping\",\n" +
                "      \"Name\": \"Fortnum & Mason\",\n" +
                "      \"Description\": \"Fortnum & Mason (colloquially often shortened to just \\\"Fortnum's\\\") is an upmarket department store in Piccadilly, London, with additional stores at St Pancras railway station and Heathrow Airport in London, as well as Dubai and various stockists worldwide. Its headquarters is located at 181 Piccadilly, where it was established in 1707 by William Fortnum and Hugh Mason. Today it is privately owned by Wittington Investments Ltd.\",\n" +
                "      \"Lattitude\": \"51.5083835\",\n" +
                "      \"Longtitude\": \"-0.1406261\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        try {
            JSONObject obj = new JSONObject(input);
            JSONArray arr = obj.getJSONArray("Sheet1");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject object = (JSONObject) arr.get(i);
                String city = (String) object.get("City");
                Category category = determineCategory((String) object.get("Category"));
                String name = (String) object.get("Name");
                String description = (String) object.get("Description");
                String lattitude = (String) object.get("Lattitude");
                String longtitude = (String) object.get("Longtitude");
                Highlight highlight = new Highlight(city, category, name, description, lattitude, longtitude);
                result.put(name, highlight);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Category determineCategory(String s) {
        Category result = Category.INVALID;
        switch(s) {
            case "Food":
                result = Category.FOOD;
                break;
            case "Culture":
                result = Category.CULTURE;
                break;
            case "Nature":
                result = Category.NATURE;
                break;
            case "Shopping":
                result = Category.SHOPPING;
                break;
            default:
                System.out.println("Not allowed");
                break;
        }
        return result;
    }
}
