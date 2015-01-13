
public class Test {
	public static void main (String[] args) {
//		String s = "afdja sjdio's skfj sdf-fe hefn:sfe fkei;wef";
//		String[] words = s.replace(",", "")
//				.replace(":", "").replace("'s", "")
//				.replace("\"", "").replace("--", " ")
//				.replace("-", " ").replace(";", "").split("\\s+");
//		for (int i = 0; i< words.length; i++) {
//			System.out.println("Length of words:" + words.length);
//			System.out.println(words[i]);
//		}
		
		
		
		String stopA = "Introduction hhh"
				+ "Rheumatoid arthritis (RA) is a disease that is dependent on genetic as well as environmental factors, as seen from both concordance data in twins and from a number of epidemiological and genetic studies [1,2]. Whereas knowledge of the genetic basis of this disease is rapidly advancing [3-5], there is a scarcity of data on environmental agents that may cause arthritis [6-9]. In particular, very little information exists in humans on environmental factors with a known capacity to induce arthritis in experimental arthritis systems."
				+ "Agents that are able to induce experimental arthritis in animals, particularly in rats, include a number of adjuvants originating from microbes such as bacteria, yeast and viruses [10,11] as well as from other sources such as mineral oils [12-14]. Arthritis may develop in certain strains of rats after exposure to adjuvants both intracutaneously and percutaneously [15]. The exact mechanisms involved in the pathogenesis of these adjuvant arthritis models are still not completely understood, but we know that mineral oil can activate cells within the lymph nodes without causing any simultaneous apparent inflammatory reaction in the skin [16]. In the context of mineral oil, we investigated the arthritogenic capacity of common cosmetics that are known to contain high amounts of mineral oils, and we observed that several such cosmetics could induce arthritis in the DA strain of rats when administered subcutaneously as well as percutaneously [16]."
				+ "It has not been established whether similar mechanisms - that is, polyarthritis induced by simple adjuvants - are operative also in human arthritis, although case reports on arthritis development after adjuvant exposures suggested that rodents and humans might both react to adjuvants with arthritis development [17]. We recently, however, used information obtained from a large ongoing case-control study (Epidemiological Investigation of Rheumatoid Arthritis (EIRA)) to describe an association between occupational exposure to mineral oil and development of RA [18]."
				+ "The combined observations from rodents on an arthritogenic capacity of cosmetics containing mineral oil, and the observation on mineral oils as a risk factor also for human RA, mandated an investigation of whether usage of cosmetics, often containing mineral oil, is associated with an increased risk for RA. We also used the large EIRA study for this purpose, utilising a series of detailed questions to cases and controls on previous use of various cosmetics as skin creams, ointments and body lotions. The level of exposure to mineral oil via cosmetic use is probably essentially lower than the level we previously analysed in the context of occupational exposure [18], but exposure via cosmetic use is very common, especially among women, and even a small increase in risk of RA might be of importance from a public health perspective.";
		String[] sentence = stopA.split("\\.");
		System.out.println("Length of sencentes:" + sentence.length);
		for (int i = 0; i< sentence.length; i++) {
			System.out.println("@@@@@@@@@@@");
			System.out.println(sentence[i]);
		}
	}
}
