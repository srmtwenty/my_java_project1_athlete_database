package com.scott.b_springData2_self_project2022a.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scott.b_springData2_self_project2022a.models.Comment;
import com.scott.b_springData2_self_project2022a.models.Competition;
import com.scott.b_springData2_self_project2022a.models.Music;
import com.scott.b_springData2_self_project2022a.models.Nation;
import com.scott.b_springData2_self_project2022a.models.Party;
import com.scott.b_springData2_self_project2022a.models.Routine;
import com.scott.b_springData2_self_project2022a.models.Swimmer;
import com.scott.b_springData2_self_project2022a.models.User;
import com.scott.b_springData2_self_project2022a.services.CommentService;
import com.scott.b_springData2_self_project2022a.services.CompetitionService;
import com.scott.b_springData2_self_project2022a.services.MusicService;
import com.scott.b_springData2_self_project2022a.services.NationService;
import com.scott.b_springData2_self_project2022a.services.PartyService;
import com.scott.b_springData2_self_project2022a.services.RoutineService;
import com.scott.b_springData2_self_project2022a.services.SwimmerService;
import com.scott.b_springData2_self_project2022a.services.UserService;

@Controller
public class CompetitionController {
	@Autowired
	private UserService userService;
	@Autowired
	private CompetitionService competitionService;
	@Autowired
	private MusicService musicService;
	@Autowired
	private NationService nationService;
	@Autowired
	private SwimmerService swimmerService;
	@Autowired
	private RoutineService routineService;
	//@Autowired
	//private GroupService groupService;
	@Autowired
	private PartyService partyService;
	@Autowired
	private CommentService commentService;
	
	private int number=0;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number=number;
	}
	
	@RequestMapping("/index")
	public String index(HttpSession session, Model model) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		return "index.jsp";
	}
	
	@RequestMapping("/home")
	public String dashboard(@ModelAttribute("competition") Competition competition, Model model, HttpSession session) {
		Integer count=getNumber();
		count++;
		setNumber(count);
		session.setAttribute("currentCount", count);
		
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
	
		List<Nation> nations=nationService.allNations();
		model.addAttribute("nations", nations);
		
		
		List<Competition> competitions=competitionService.allCompetitions();
		model.addAttribute("competitions", competitions);
		
		List<Routine> routines=routineService.allRoutines();
		model.addAttribute("routines", routines);
		
		return "home.jsp";
	}
	@RequestMapping("/competitions/new")
	public String newCompetition(@ModelAttribute("competition") Competition competition) {
		return "newCompetition.jsp";
	}
	
	@RequestMapping(value="/competitions/create", method=RequestMethod.POST)
	public String createCompetition(@Valid @ModelAttribute("competition") Competition competition, BindingResult result, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		if(result.hasErrors()) {
			System.out.println("Error!");
			//User u=userService.findUser(loggedId);
			return "home.jsp";
		}else {
			User host=userService.findUser(loggedId);
			competition.setHost(host);
			
			competitionService.createCompetition(competition);
			System.out.println("Yes!");
			return "redirect:/home";
		}
	}
	@RequestMapping("/competitions/{id}")
	public String showCompetition(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		Competition c=competitionService.findCompetition(id);
		model.addAttribute("competition", c);
		
		List<Party> compParties=c.getParties();
		model.addAttribute("compParties", compParties);
		
		List<Party> parties=partyService.allParties();
		model.addAttribute("parties", parties);
		
		List<Comment> cComments=c.getComments();
		model.addAttribute("cComments", cComments);
		return "showCompetition.jsp";
	}
	@RequestMapping("/competitions/{id}/edit")
	public String editCompetition(@PathVariable("id") Long id, @ModelAttribute("competition") Competition competition, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		return "editCompetition.jsp";
	}
	@RequestMapping(value="/competitions/{id}/edit", method=RequestMethod.PUT)
	public String updateCompetition(@Valid @ModelAttribute("competition") Competition competition, BindingResult result, @PathVariable("id") Long id, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		if(result.hasErrors()) {
			return "/editCompetition.jsp";
		}else {
			competitionService.updateCompetition(competition);
			return "redirect:/competition/"+id;
		}
		
	}
	//@RequestMapping(value="/competitions/{id}/addParty", method=RequestMethod.POST)
	//public String addParty(@PathVariable("id") Long id, @RequestParam("party") Long partyId) {
	//	Competition c=competitionService.findCompetition(id);
	//	Party p=partyService.findParty(partyId);
	//	c.addParty(p);
	//	competitionService.updateCompetition(c);
	//	
	//	System.out.println("YES");
	//	return "redirect:/competitions/"+id;
	//}
	
	@RequestMapping("/competitions/nations/new")
	public String newNation(@ModelAttribute("nation") Nation nation, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		return "newNation.jsp";
	}
	
	@RequestMapping(value="/competitions/nations/new", method=RequestMethod.POST)
	public String createNation(@Valid @ModelAttribute("nation") Nation nation, BindingResult result, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		if(result.hasErrors()) {
			return "newNation.jsp";
		}else {
			nationService.createNation(nation);
			return "redirect:/competitions/swimmers/new";
		}
	}
	@RequestMapping("/competitions/nations/{id}")
	public String showNation(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		Nation nation=nationService.findNation(id);
		model.addAttribute("nation", nation);
		
		List<Swimmer> swimmers=nation.getSwimmers();
		model.addAttribute("swimmers", swimmers);
		
		Long number=swimmerService.countByNation(id);
		System.out.println("number:"+number);
		model.addAttribute("number", number);
		
		return "showNation.jsp";
	}
	
	@RequestMapping("/competitions/swimmers/new")
	public String newSwimmer(@ModelAttribute("swimmer") Swimmer swimmer, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		List<Nation> nations=nationService.allNations();
		model.addAttribute("nations", nations);
		return "newSwimmer.jsp";
	}
	
	@RequestMapping(value="/competitions/swimmers/new", method=RequestMethod.POST)
	public String createSwimmer(@Valid @ModelAttribute("swimmer") Swimmer swimmer, BindingResult result, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		
		if(result.hasErrors()) {
			return "newSwimmer.jsp";
		}else {
			User host=userService.findUser(loggedId);
			swimmer.setHost(host);
			swimmerService.createSwimmer(swimmer);
			return "redirect:/competitions/swimmers/"+swimmer.getId();
		}
	}
	@RequestMapping("/competitions/swimmers")
	public String allSwimmers(Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		List<Swimmer> swimmers=swimmerService.allSwimmers();
		model.addAttribute("swimmers", swimmers);
		return "allSwimmers.jsp";
	}
	
	@RequestMapping("/competitions/swimmers/{id}")
	public String showSwimmer(@PathVariable("id") Long id, Model model, @ModelAttribute("comment") Comment comment, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		Swimmer s=swimmerService.findSwimmer(id);
		model.addAttribute("swimmer", s);
		
		List<Comment> comments=s.getComments();
		model.addAttribute("comments", comments);
		return "showSwimmer.jsp";
	}
	@RequestMapping("/competitions/swimmers/{id}/edit")
	public String editSwimmer(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		Swimmer s=swimmerService.findSwimmer(id);
		model.addAttribute("swimmer", s);
		List<Nation> nations=nationService.allNations();
		model.addAttribute("nations", nations);
		return "editSwimmer.jsp";
	}
	@RequestMapping(value="/competitions/swimmers/{id}/edit", method=RequestMethod.PUT)
	public String updateSwimmer(@Valid @ModelAttribute("swimmer") Swimmer swimmer, BindingResult result, @PathVariable("id") Long id, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		
		if(result.hasErrors()) {
			return "editSwimmer.jsp";
		}else {
			swimmerService.updateSwimmer(swimmer);
			return "redirect:/competitions/swimmers/"+swimmer.getId();
		}
	}
	
	//new routine
	@RequestMapping("/competitions/routines/new")
	public String newRoutine(@ModelAttribute("routine") Routine routine, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		//List<Competition> competitions=competitionService.allCompetitions();
		//model.addAttribute("competitions", competitions);
		return "newRoutine.jsp";
	}
	@RequestMapping(value="/competitions/routines/new", method=RequestMethod.POST)
	public String createRoutine(@Valid @ModelAttribute("routine") Routine routine, BindingResult result, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		
		if(result.hasErrors()) {
			System.out.println("Error!");
			return "newRoutine.jsp";
		}else {
			routineService.createRoutine(routine);
			System.out.println("YES!");
			return "redirect:/competitions/routines/"+routine.getId();
		}
	}
	//@RequestMapping("/competitions/routines/{id}")
	//public String showRoutine(@PathVariable("id") Long id, Model model, @ModelAttribute("party") Party party) {
	//	Routine routine=routineService.findRoutine(id);
	//	model.addAttribute("routine", routine);
	//	
	//	List<Competition> competitions=routine.getCompetitions();
	//	model.addAttribute("competitions", competitions);
	//	List<Party> parties=routine.getParties();
	//	model.addAttribute("parties", parties);
	//	
	//	return "showRoutine.jsp";
	//}
	@RequestMapping("/competitions/routines/{id}")
	public String showRoutine(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		Routine r=routineService.findRoutine(id);
		model.addAttribute("routine", r);
		
		List<Competition> competitions=r.getCompetitions();
		model.addAttribute("competitions", competitions);
		List<Party> parties=r.getParties();
		model.addAttribute("parties", parties);
		
		return "showRoutine.jsp";
	}
	@RequestMapping(value="/competitions/routines/{id}/addComp")
	public String addCompetition(@PathVariable("id") Long id, @RequestParam("competition") Long compId, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		
		Routine r=routineService.findRoutine(id);
		Competition c=competitionService.findCompetition(compId);
		r.addCompetition(c);
		routineService.updateRoutine(r);
		return "redirect:/competitions/routines/"+id;
	}
	@RequestMapping("/competitions/{id}/remove")
	public String remove(@PathVariable("id") Long id, @ModelAttribute("party") Party party, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		
		Competition c=competitionService.findCompetition(id);
		Party p=partyService.findParty(party.getId());
		List<Party> parties=c.getParties();
		parties.remove(p);
		c.setParties(parties);
		competitionService.updateCompetition(c);
		return "redirect:/competitions/"+id;
	}
	
	//@RequestMapping(value="/competitions/routines/{id}/join", method=RequestMethod.POST)
	//public String addParty(@PathVariable("id") Long id, @Valid @ModelAttribute("party") Party party, BindingResult result) {		
	//	Routine r=routineService.findRoutine(id);
	//	List<Party> parties=r.getParties();
	//	parties.add(party);
	//	r.setParties(parties);
	//	routineService.updateRoutine(r);
	//	return "redirect:/competitions/routines/"+r.getId();
	//}
	//@RequestMapping("/competitions/routines/{id}/remove")
	//public String removeParty(@PathVariable("id") Long id, @ModelAttribute("party") Party party) {
	//	Routine r=routineService.findRoutine(id);
	//	List<Party> parties=r.getParties();
	//	parties.remove(party);
	//	r.setParties(parties);
	//	routineService.updateRoutine(r);
	//	return "redirect:/competitions/routines/"+r.getId();
	//}
	
	@RequestMapping("/competitions/parties/new")
	public String newParty(@ModelAttribute("party") Party party, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		List<Nation> nations=nationService.allNations();
		model.addAttribute("nations", nations);
		List<Routine> routines=routineService.allRoutines();
		model.addAttribute("routines", routines);
		List<Competition> competitions=competitionService.allCompetitions();
		model.addAttribute("competitions", competitions);
		
		//List<Swimmer> swimmers=swimmerService.allSwimmers();
		//model.addAttribute("swimmers", swimmers);
		return "newParty.jsp";
	}
	@RequestMapping(value="/competitions/parties/new", method=RequestMethod.POST)
	public String createParty(@Valid @ModelAttribute("party") Party party, BindingResult result, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		if(result.hasErrors()) {
			return "newParty.jsp";
		}
		User host=userService.findUser(loggedId);
		party.setHost(host);
		
		partyService.createParty(party);
		return "redirect:/competitions/parties/"+party.getId();
	}
	
	@RequestMapping(value="/competitions/parties/{id}")
	public String showParty(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		Party p=partyService.findParty(id);
		model.addAttribute("party", p);
		List<Swimmer> pSwimmers=p.getSwimmers();
		model.addAttribute("pSwimmers", pSwimmers);
		
		List<Swimmer> swimmers=swimmerService.allSwimmers();
		model.addAttribute("swimmers", swimmers);
		
		List<Music> pMusics=p.getMusics();
		model.addAttribute("pMusics", pMusics);
		
		List<Music> musics=musicService.allMusic();
		model.addAttribute("musics", musics);
		
		List<Comment> comments=p.getComments();
		model.addAttribute("comments", comments);
		
		List<Swimmer> coaches=p.getCoaches();
		model.addAttribute("coaches", coaches);
		
		Competition c=p.getCompetition();
		model.addAttribute("competition", c);
		return "showParty.jsp";
	}
	
	@RequestMapping("/competitions/parties/{id}/edit")
	public String editParty(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		Party p=partyService.findParty(id);
		model.addAttribute("party", p);
		List<Nation> nations=nationService.allNations();
		model.addAttribute("nations", nations);
		List<Routine> routines=routineService.allRoutines();
		model.addAttribute("routines", routines);
		List<Competition> competitions=competitionService.allCompetitions();
		model.addAttribute("competitions", competitions);
		List<Swimmer> swimmers=swimmerService.allSwimmers();
		model.addAttribute("swimmers", swimmers);
		return "editParty.jsp";
	}
	@RequestMapping(value="/competitions/parties/{id}/edit", method=RequestMethod.PUT)
	public String updateParty(@PathVariable("id") Long id, @Valid @ModelAttribute("party") Party party, BindingResult result, HttpSession session, Model model) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		//User u=userService.findUser(loggedId);
		//model.addAttribute("loggedUser", u);
		
		if(result.hasErrors()) {
			return "editParty.jsp";
		}else {
			User host=userService.findUser(loggedId);
			party.setHost(host);
			
			partyService.updateParty(party);
			return "redirect:/competitions/parties/"+id;
		}
	}
	
	@RequestMapping("/competitions/parties/{id}/addMusic")
	public String addMusic(@PathVariable("id") Long id, @RequestParam("music") Long musicId) {
		Party p=partyService.findParty(id);
		Music m=musicService.findMusic(musicId);
		
		List<Music> musics=p.getMusics();
		musics.add(m);
		p.setMusics(musics);
		partyService.updateParty(p);
		return "redirect:/competitions/parties/"+id;
	}
	@RequestMapping("/competitions/{id}/addSwimmer")
	public String addSwimmer(@PathVariable("id") Long id, @RequestParam("swimmer") Long swimmerId, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		
		Party p=partyService.findParty(id);
		Swimmer s=swimmerService.findSwimmer(swimmerId);
		
		List<Swimmer> swimmers=p.getSwimmers();
		swimmers.add(s);
		p.setSwimmers(swimmers);
		partyService.updateParty(p);
		return "redirect:/competitions/parties/"+id;
	}
	@RequestMapping("/competitions/parties/{id}/addCoach")
	public String addCoach(@PathVariable("id") Long id, @RequestParam("coach") Long coachId, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		Party p=partyService.findParty(id);
		Swimmer c=swimmerService.findSwimmer(coachId);
		
		List<Swimmer> coaches=p.getCoaches();
		coaches.add(c);
		p.setCoaches(coaches);
		partyService.updateParty(p);
		return "redirect:/competitions/parties/"+id;
	}
	
	@RequestMapping("/competitions/parties/{id}/removeSwimmer")
	public String removeSwimmer(@PathVariable("id") Long id, @RequestParam("party") Long partyId, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		
		Party p=partyService.findParty(partyId);
		Swimmer s=swimmerService.findSwimmer(id);
		
		List<Swimmer> swimmers=p.getSwimmers();
		swimmers.remove(s);
		p.setSwimmers(swimmers);
		partyService.updateParty(p);
		return "redirect:/competitions/parties/"+partyId;
	}
	//@RequestMapping("/competitions/parties/{id}/removeSwimmer")
	//public String removeSwimmer(@PathVariable("id") Long id, @ModelAttribute("swimmer") Swimmer swimmer) {
	//	Party p=partyService.findParty(id);
	//	Swimmer s=swimmerService.findSwimmer(swimmer.getId());
	
	//	p.removeSwimmer(s);
	//	partyService.updateParty(p);
	//	return "redirect:/competitions/parties/"+id;
	//}
	//@RequestMapping("/competitions/parties/{id}/removeSwimmer")
	//public String removeSwimmer(@PathVariable("id") Long id, @ModelAttribute("party") Party party) {
		//Party p=partyService.findParty(id);
		//Swimmer s=swimmerService.findSwimmer(swimmer.getId());
		//p.removeSwimmer(s);
		//partyService.updateParty(p);
	//	Swimmer s=swimmerService.findSwimmer(id);
	//	Party p=swimmerService.
		
	//	return "redirect:/competitions/parties/"+id;
	//}
	
	
	@RequestMapping("/competitions/musics/{id}")
	public String showMusic(@PathVariable("id") Long id, Model model, @ModelAttribute("party") Party party, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		Music m=musicService.findMusic(id);
		model.addAttribute("music", m);
		
		
		List<Party> parties=partyService.allParties();
		model.addAttribute("parties", parties);
		
		List<Party> sParties=m.getParties();
		model.addAttribute("sParties", sParties);
		
		List<Comment> comments=m.getComments();
		model.addAttribute("comments", comments);
		return "showMusic.jsp";
	}
	
	@RequestMapping("/competitions/musics/{id}/addParty")
	public String addParty(@PathVariable("id") Long id, Model model, @RequestParam("party") Long partyId, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		
		Music m=musicService.findMusic(id);
		List<Party> parties=m.getParties();
		
		Party p=partyService.findParty(partyId);
		parties.add(p);
		m.setParties(parties);
		musicService.updateMusic(m);
		return "redirect:/competitions/musics/"+id;
	}
	
	@RequestMapping(value="/competitions/musics/{id}/removeParty", method=RequestMethod.POST)
	public String removeParty(@PathVariable("id") Long id, @RequestParam("party") Long partyId, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		
		Music m=musicService.findMusic(id);
		List<Party> parties=m.getParties();
		
		Party p=partyService.findParty(partyId);
		parties.remove(p);
		m.setParties(parties);
		musicService.updateMusic(m);
		return "redirect:/competitions/musics/"+id;
	}
	@RequestMapping("/competitions/musics/{id}/edit")
	public String editMusic(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		Music music=musicService.findMusic(id);
		model.addAttribute("music", music);
		
		return "editMusic.jsp";
	}
	@RequestMapping(value="/competitions/musics/{id}/edit", method=RequestMethod.PUT)
	public String updateMusic(@Valid @ModelAttribute("music") Music music, BindingResult result, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		musicService.updateMusic(music);
		return "redirect:/competitions/musics/"+music.getId();
	}
	
	@RequestMapping("/competitions/musics/new")
	public String newMusic(@ModelAttribute("music") Music music, HttpSession session, Model model) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		return "newMusic.jsp";
	}
	@RequestMapping(value="/competitions/musics/new", method=RequestMethod.POST)
	public String createMusic(@Valid @ModelAttribute("music") Music music, BindingResult result, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		
		if(result.hasErrors()) {
			System.out.println("WRONG!");
			return "newMusic.jsp";
		}else {
			User host=userService.findUser(loggedId);
			music.setHost(host);
			musicService.createMusic(music);
			return "redirect:/competitions/musics/"+music.getId();
		}
	}
	@RequestMapping("/competitions/musics")
	public String musics(Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		List<Music> musics=musicService.allMusic();
		model.addAttribute("musics", musics);
		return "allMusics.jsp";
	}
	@RequestMapping("/competitions/musics/{id}/delete")
	public String deleteMusic(@PathVariable("id") Long id) {
		musicService.deleteMusic(id);
		return "redirect:/competitions/musics";
	}
	
	@RequestMapping(value="/competitions/parties/{id}/delete", method=RequestMethod.DELETE)
	public String deleteParty(@PathVariable("id") Long id, HttpSession session) {
		//Long loggedId=(Long) session.getAttribute("loggedId");
		//if(loggedId==null) {
		//	return "redirect:";
		//}
		
		partyService.deleteParty(id);
		return "redirect:/competitions/parties/"+id;
	}
	@RequestMapping("/competitions/parties")
	public String allParties(Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		List<Party> parties=partyService.allParties();
		model.addAttribute("parties", parties);
		return "allParties.jsp";
	}
	//@RequestMapping(value="/competition/${id}/remove")
	//public String removeCompetition(@PathVariable("id") Long id, @RequestParam("party") Long partyId) {
	//	
	//	Competition c=competitionService.findCompetition(id);
	//	Party p=partyService.findParty(partyId);
	//	List<Party> parties=c.getParties();
	//	parties.remove(p);
	//	c.setParties(parties);
	//	competitionService.updateCompetition(c);
	//	return "redirect:/home";
	//}
	@RequestMapping("/search0")
	public String search(@RequestParam(value="searchQ", required=false) String searchQ) {
		return "redirect:/competitions/search0/"+searchQ;
	}
	@RequestMapping("/competitions/search0/{searchN}")
	public String searchSwimmersByNation(@PathVariable("searchN") String searchN, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		List<Swimmer> swimmersBN=swimmerService.findByNation(searchN);
		model.addAttribute("swimmersBN", swimmersBN);
		model.addAttribute("searchN", searchN);
		return "result.jsp";
	}
	@RequestMapping("/se")
	public String search1(@RequestParam(value="searchQ1", required=false) int searchQ1) {
		return "redirect:/search/"+searchQ1;
	}
	@RequestMapping("/search/{searchA}")
	public String result1(@PathVariable("searchA") int searchA, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		List<Swimmer> swimmersBB=swimmerService.findByBirthYear(searchA);
		model.addAttribute("swimmersBB", swimmersBB);
		model.addAttribute("searchA", searchA);
		return "result1.jsp";
	}
	@RequestMapping("/se2")
	public String search2(@RequestParam("searchQ2") String searchQ2) {
		return "redirect:/search2/"+searchQ2;
	}
	@RequestMapping("/search2/{searchA2}")
	public String result2(@PathVariable("searchA2") String searchA2, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		List<Swimmer> swimmersBL=swimmerService.findByName(searchA2);
		model.addAttribute("swimmersBL", swimmersBL);
		model.addAttribute("searchA2", searchA2);
		return "result2.jsp";
	}
	//@RequestMapping("/se3")
	//public String search3(@RequestParam("searchQ3a") String searchQ3a, @RequestParam("searchQ3b") String searchQ3b) {
	//	return "redirect:/search3/"+searchQ3a+" "+searchQ3b;
	//}
	//@RequestMapping("/search3/{searchA3a} {searchA3b}")
	//public String result3(@PathVariable("searchA3a") String searchA3a, @PathVariable("searchA3b") String searchA3b, Model model, HttpSession session) {
	//	List<Swimmer> swimmersBFN=swimmerService.findByName(searchA3a, searchA3b);
	//	model.addAttribute("swimmersBFN", swimmersBFN);
	//	model.addAttribute("searchA3a", searchA3a);
	//	model.addAttribute("searchA3b", searchA3b);
	//	return "result3.jsp";
	//}
	@RequestMapping("/competitions/swimmers/birthOrder")
	public String sortSwimmerBirth(Model model) {
		List<Swimmer> swimmers=swimmerService.findByOrderByBirthYearDesc();
		model.addAttribute("swimmers", swimmers);
		return "sortBirth.jsp";
	}
	@RequestMapping("/competitions")
	public String allCompetitions(Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		List<Competition> competitions=competitionService.allCompetitions();
		model.addAttribute("competitions", competitions);
		return "allCompetitions.jsp";
	}
	@RequestMapping("/competitions/yearAsc")
	public String allCompetitionsYearAsc(Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		List<Competition> competitionsAsc=competitionService.findByOrderByYearAsc();
		model.addAttribute("competitionsAsc", competitionsAsc);
		return "allCompetitionsAsc.jsp";
	}
	@RequestMapping("/competitions/yearDesc")
	public String allCompetitionsYearDesc(Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		List<Competition> competitionsDesc=competitionService.findByOrderByYearDesc();
		model.addAttribute("competitionsDesc", competitionsDesc);
		return "allCompetitionsDesc.jsp";
	}
	//@RequestMapping("/se4")
	//public String search4(@RequestParam(value="searchQ4", required=false) String searchQ4) {
	//	return "/search4/"+searchQ4;
	//}
	//@RequestMapping("/search4/{searchA4}")
	//public String result4(@PathVariable("searchA4") String searchA4, Model model) {
	//	List<Competition> competitionSearches=competitionService.search(searchA4);
	//	model.addAttribute("competitionSearches", competitionSearches);
	//	model.addAttribute("searchA4", searchA4);
	//	return "result4.jsp";
	//}
	@RequestMapping(value="/competitions/{id}/delete", method=RequestMethod.DELETE)
	public String deleteCompetition(@PathVariable("id") Long id) {
		competitionService.deleteCompetition(id);
		return "redirect:/competitions";
	}
	@RequestMapping("/competitions/swimmers/{id}/delete")
	public String deleteSwimmer(@PathVariable("id") Long id) {
		swimmerService.deleteSwimmer(id);
		return "redirect:/competitions/swimmers";
	}
	
	@RequestMapping("/competitions/swimmers/{id}/addComment")
	public String addCommentSw(@RequestParam("content") String content, @PathVariable("id") Long id, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		
			User host=userService.findUser(loggedId);
			
			
			
			Comment c=new Comment();
			//c.setHost(host);
			c.setContent(content);
			
			Swimmer s=swimmerService.findSwimmer(id);
			c.setSwimmer(s);
			c.setHost(host);
			//Swimmer s=swimmerService.findSwimmer(id);
			//List<Comment> comments=s.getComments();
			
			//comments.add(commentService.createComment(comment));
			commentService.updateComment(c);
			
			return "redirect:/competitions/swimmers/"+id;
	}
	@RequestMapping("/competitions/parties/{id}/addComment")
	public String addCommentParty(@RequestParam("content") String content, @PathVariable("id") Long id, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User host=userService.findUser(loggedId);
		
		Comment c=new Comment();
		c.setContent(content);
	
		Party p=partyService.findParty(id);
		c.setParty(p);
		c.setHost(host);
		
		commentService.updateComment(c);
		return "redirect:/competitions/parties/"+id;
	}
	@RequestMapping("/competitions/musics/{id}/addComment")
	public String addCommentMusic(@RequestParam("content") String content, @PathVariable("id") Long id, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User host=userService.findUser(loggedId);
		
		Comment c=new Comment();
		c.setContent(content);
		
		Music m=musicService.findMusic(id);
		c.setMusic(m);
		c.setHost(host);
		
		commentService.updateComment(c);
		return "redirect:/competitions/musics"+id;
	}
	@RequestMapping("/competitions/{id}/addComment")
	public String addCommentComp(@RequestParam("content") String content, @PathVariable("id") Long id, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User host=userService.findUser(loggedId);
		
		Comment c=new Comment();
		c.setContent(content);
		
		Competition comp=competitionService.findCompetition(id);
		c.setCompetition(comp);
		c.setHost(host);
		
		commentService.updateComment(c);
		return "redirect:/competitions/"+id;
	}
}
