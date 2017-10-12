package es.upm.miw.apaw.theme.api.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.dtos.VoteDto;
import es.upm.miw.apaw.theme.api.entities.Theme;
import es.upm.miw.apaw.theme.api.entities.Reservation;

public class VoteController {

    public boolean createVote(int themeId, int vote) {
        Theme theme = DaoFactory.getFactory().getThemeDao().read(themeId);
        if (theme != null) {
            DaoFactory.getFactory().getVoteDao().create(new Reservation(vote, theme));
            return true;
        } else {
            return false;
        }
    }

    public List<VoteDto> voteList() {
        List<VoteDto> voteDtoList = new ArrayList<>();
        List<Reservation> votes = DaoFactory.getFactory().getVoteDao().findAll();
        for (Reservation vote : votes) {
            voteDtoList.add(new VoteDto(vote));
        }
        return voteDtoList;
    }

}
