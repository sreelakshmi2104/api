package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.TeamAwardsTMD;
import spring.spot.trial.Repository.TeamAwardsTMDRepository;

import java.util.List;

@Service
public class TeamAwardsTMDService {
    @Autowired
    TeamAwardsTMDRepository teamAwardsTMDRepository;

    public TeamAwardsTMDService(TeamAwardsTMDRepository teamAwardsTMDRepository) {
        this.teamAwardsTMDRepository = teamAwardsTMDRepository;
    }

    public TeamAwardsTMD createTeamAwards(TeamAwardsTMD team) {
        return teamAwardsTMDRepository.save(team);
    }

    public List<TeamAwardsTMD> getAllTeamAwards() {
        return teamAwardsTMDRepository.findAll();
    }

    public List<TeamAwardsTMD> getTeamAwardsById(int id) {
        return teamAwardsTMDRepository.findByTeamId(id);
    }

    public TeamAwardsTMD updateTeamAwardsById(int id, TeamAwardsTMD teamAwardsTMD) { return teamAwardsTMDRepository.save(teamAwardsTMD); }


}
