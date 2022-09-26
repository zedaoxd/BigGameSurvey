import { Link } from "react-router-dom";
import "./styles.css";

type Props = {
  link: string;
  linkText: string;
};

const Filters = (props: Props) => {
  return (
    <div className="filters-container records-actions">
      <Link to={props.link}>
        <button className="action-filters">{props.linkText}</button>
      </Link>
    </div>
  );
};

export default Filters;
