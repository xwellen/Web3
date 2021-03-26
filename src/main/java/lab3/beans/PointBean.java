package lab3.beans;

import lab3.model.PointDao;
import lab3.model.Point;
import org.primefaces.PrimeFaces;

import java.io.Serializable;

public class PointBean implements Serializable {
    private Double inputX;
    private Double inputY;
    private Double inputR;

    private PointsBean points;
    private PointDao pointDao;

    public void addPoint() {
        Point point = new Point(inputX, inputY, inputR);
        points.addToPoints(point);
        getPointsForCanvas();
        pointDao.save(point);
    }

    public void getPointsForCanvas() {
        PrimeFaces.current().ajax().addCallbackParam("points", points);
    }

    public Double getInputX() {
        return inputX;
    }

    public void setInputX(Double inputX) {
        this.inputX = inputX;
    }

    public Double getInputY() {
        return inputY;
    }

    public void setInputY(Double inputY) {
        this.inputY = inputY;
    }

    public Double getInputR() {
        return inputR;
    }

    public void setInputR(Double inputR) {
        this.inputR = inputR;
    }

    public void setPoints(PointsBean points) {
        this.points = points;
    }

    public void setPointDao(PointDao pointDao) {
        this.pointDao = pointDao;
    }
}
