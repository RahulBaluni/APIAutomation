package dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUsersResponse {

    private Integer per_page;
    private Integer total;
    private List<Data> data;
    private Integer page;
    private Integer total_pages;
    private Support support;
}
