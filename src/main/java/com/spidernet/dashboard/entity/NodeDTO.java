package com.spidernet.dashboard.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by Richard on 2018/2/1.
 */
public class NodeDTO {

    private String knowledgePoint;

    private String text;

    private List<NodeDTO> nodes;

    private Map<String,Object> state;

    public String getKnowledgePoint() {
        return knowledgePoint;
    }

    public void setKnowledgePoint(String knowledgePoint) {
        this.knowledgePoint = knowledgePoint;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<NodeDTO> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeDTO> nodes) {
        this.nodes = nodes;
    }

    public Map<String, Object> getState() {
        return state;
    }

    public void setState(Map<String, Object> state) {
        this.state = state;
    }
}
