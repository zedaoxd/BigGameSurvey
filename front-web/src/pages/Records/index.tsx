import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Filters from "../../components/Filters";
import { formatDate } from "./helpers";
import Pagination from "./Pagination";
import "./styles.css";
import { RecordsResponse } from "./types";

const BASE_URL = "http://localhost:8080";

const Records = () => {
  const [recordsResponse, setRecordsResponse] = useState<RecordsResponse>();
  const [activePage, setActivePage] = useState<number>(0);

  useEffect(() => {
    axios
      .get(`${BASE_URL}/records?size=12&sort=moment,DESC&page=${activePage}`)
      .then((response) => setRecordsResponse(response.data));
  }, [activePage]);

  return (
    <div className="page-container">
      <Filters linkText="VER GRÁFICO" link="/charts" />
      <table className="records-table" cellPadding="0" cellSpacing="0">
        <thead>
          <tr>
            <th>INSTANTE</th>
            <th>NOME</th>
            <th>IDADE</th>
            <th>PLATAFORMA</th>
            <th>GÊNERO</th>
            <th>TÍTULO DO GAME</th>
          </tr>
        </thead>
        <tbody>
          {recordsResponse?.content?.map((record) => (
            <tr key={record.id}>
              <td>{formatDate(record.moment)}</td>
              <td>{record.name}</td>
              <td>{record.age}</td>
              <td className="text-secondary">{record.plataform}</td>
              <td>{record.genreName}</td>
              <td className="text-primary">{record.gameTitle}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <Pagination
        activePage={activePage}
        totalPages={recordsResponse?.totalPages}
        goToPage={(index: number) => setActivePage(index)}
      />
    </div>
  );
};

export default Records;
